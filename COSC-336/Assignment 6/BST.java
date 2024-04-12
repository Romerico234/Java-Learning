import java.util.*;
import java.io.*;

// Java program to search a given key in a given BST
class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

class BinarySearchTree {
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// A utility function to insert
	// a new node with given key in BST
	Node insert(Node node, int key) {
		// If the tree is empty, return a new node
		if (node == null) {
			node = new Node(key);
			return node;
		}

		// Otherwise, recur down the tree
		if (key <= node.key) // Adds the key to the left subtree if the key is less than or EQUAL to the root
			node.left = insert(node.left, key);
		else
			node.right = insert(node.right, key);

		// return the (unchanged) node pointer
		return node;
	}

	// Utility function to search a key in a BST
	Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
			return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

	int size(Node node) {
		if (node == null)
			return 0;
		return size(node.left) + size(node.right) + 1;
	}

	Node leftRotate(Node t) {
		Node x = t.right;
		t.right = x.left;
		x.left = t;
		return x;
	}

	Node rightRotate(Node t) {
		Node x = t.left;
		t.left = x.right;
		x.right = t;
		return x;
	}

	void printPreorder(Node node) {
		if (node == null)
			return;
		// add commas between each pair but exclude the last pair
		System.out.print("(" + node.key + "," + size(node) + ")");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	public static void main(String[] args) {
		int[] data1 = { 7, 10, 3, 9, 13, 11 };
		int[] data2 = fileReader("input-6-1.txt");
		int[] data3 = fileReader("input-6-2.txt");

		BinarySearchTree A = insertToBST(data1);
		BinarySearchTree B = insertToBST(data2);
		BinarySearchTree C = insertToBST(data3);

		System.out.print("Preorder traversal of A is: ");
		A.printPreorder(A.root);
		System.out.println();
		// Left rotating the tree
		A.root = A.leftRotate(A.root);
		System.out.print("Preorder traversal of A after left rotation is: ");
		A.printPreorder(A.root);
		System.out.println();

		System.out.println("---------------------------------");

		// System.out.print("Preorder traversal of B is: ");
		// B.printPreorder(B.root);
		// System.out.println();
		// B.root = B.leftRotate(B.root);
		// System.out.print("Preorder traversal of B after left rotation is: ");
		// B.printPreorder(B.root);
		// System.out.println();

		// System.out.println("---------------------------------");

		// // System.out.print("Preorder traversal of C is: ");
		// // C.printPreorder(C.root);
		// // System.out.println();
		// // C.root = C.leftRotate(C.root);
		// // System.out.print("Preorder traversal of C after left rotation is: ");
		// // C.printPreorder(C.root);
		// // System.out.println();
	}

	public static int[] fileReader(String fileName) {
		try {
			File file = new File(fileName);
			Scanner fileReader = new Scanner(file);
			int size = 0;
			if (fileReader.hasNextInt())
				size = fileReader.nextInt();
			int[] list = new int[size];
			int i = 0;
			while (fileReader.hasNextInt())
				list[i++] = fileReader.nextInt();
			fileReader.close();
			return list;
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		return null;
	}

	public static BinarySearchTree insertToBST(int[] list) {
		BinarySearchTree tree = new BinarySearchTree();
		for (int i = 0; i < list.length; i++) {
			tree.root = tree.insert(tree.root, list[i]);
		}
		return tree;
	}
}
