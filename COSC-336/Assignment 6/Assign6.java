import java.util.*;
import java.io.*;

class Node {
	int key;
	int size; // New field for the size of the subtree rooted at this node
	Node left, right;

	public Node(int item) {
		key = item;
		size = 1; // Initialize size to 1 for a single node
		left = right = null;
	}
}

class BinarySearchTree {
	Node root;

	BinarySearchTree() {
		root = null;
	}

	Node insert(Node node, int key) {
		if (node == null) {
			node = new Node(key);
			return node;
		}

		if (key <= node.key) 
			node.left = insert(node.left, key);
		else 
			node.right = insert(node.right, key);
		
		node.size++;

		return node;
	}

	Node search(Node root, int key) {
		if (root == null || root.key == key)
			return root;

		if (root.key < key)
			return search(root.right, key);

		return search(root.left, key);
	}

	Node leftRotate(Node t) {
		if (t.right == null)
			return t;
		Node x = t.right;
		t.right = x.left;
		x.left = t;

		// Update sizes of the rotated nodes
		t.size = 1 + (t.left != null ? t.left.size : 0) + (t.right != null ? t.right.size : 0); 
		x.size = 1 + (x.left != null ? x.left.size : 0) + (x.right != null ? x.right.size : 0);

		return x; 
	}

	Node rightRotate(Node t) {
		if (t.left == null)
			return t;
		Node x = t.left;
		t.left = x.right;
		x.right = t;

		// Update sizes of the rotated nodes
		t.size = 1 + (t.left != null ? t.left.size : 0) + (t.right != null ? t.right.size : 0);
		x.size = 1 + (x.left != null ? x.left.size : 0) + (x.right != null ? x.right.size : 0);

		return x; 
	}

	void printPreorder(Node node) {
		if (node == null)
			return;
		//Node, Left, Right
		System.out.print("(" + node.key + "," + node.size + "),");
		printPreorder(node.left);
		printPreorder(node.right);
	}
}

public class Assign6 {
	public static void main(String[] args) {
		int[] data1 = { 7, 10, 3, 9, 13, 11 };
		int[] data2 = fileReader("input-6-1.txt");
		int[] data3 = fileReader("input-6-2.txt");

		BinarySearchTree A = insertToBST(data1);
		BinarySearchTree B = insertToBST(data2);
		BinarySearchTree C = insertToBST(data3);

		// System.out.print("Preorder traversal of A is: ");
		// A.printPreorder(A.root);
		// System.out.println();
		// // Left rotating the tree
		// A.root = A.leftRotate(A.root);
		// System.out.print("\nPreorder traversal of A after left rotation is: ");
		// A.printPreorder(A.root);
		// System.out.println();

		// System.out.println("---------------------------------");

		// System.out.print("Preorder traversal of B is: ");
		// B.printPreorder(B.root);
		// System.out.println();
		// B.root = B.leftRotate(B.root);
		// System.out.print("\nPreorder traversal of B after left rotation is: ");
		// B.printPreorder(B.root);
		// System.out.println();

		// System.out.println("---------------------------------");

		// // System.out.print("Preorder traversal of C is: ");
		// // C.printPreorder(C.root);
		// // System.out.println();
		C.root = C.leftRotate(C.root);
		System.out.print("\nPreorder traversal of C after left rotation is: ");
		C.printPreorder(C.root);
		System.out.println();
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