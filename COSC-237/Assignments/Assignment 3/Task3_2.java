import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please input the name of the file to be opened for the first list: ");
        OrderedArrayList list1 = retrieveFromFile(input.next());

        System.out.print("Please input the name of the file to be opened for the second list: ");
        OrderedArrayList list2 = retrieveFromFile(input.next());

        System.out.println("The first list is: ");
        list1.print();

        System.out.println("The second list is: ");
        list2.print();

        System.out.println("The merged list is: ");
        OrderedArrayList merged_list = list1.merge(list2);
        merged_list.print();

        OrderedArrayList split1 = new OrderedArrayList();
        OrderedArrayList split2 = new OrderedArrayList();

        int key = getInt(input, "Enter key for split: ");
        merged_list.split(split1, split2, key);
        System.out.println("The first list after split is: ");
        split1.print();
        System.out.println("The second list after split is: ");
        split2.print();
    }

    public static OrderedArrayList retrieveFromFile(String fileName) {
        int size = 0;
        OrderedArrayList list = null;
        try {
            Scanner inputFile = new Scanner(new File(fileName));

            while (inputFile.hasNext()) {
                if (inputFile.hasNextInt()) {
                    inputFile.nextInt();
                    size++;
                } else 
                    inputFile.next();
            }

            if (size == 0) {
                System.out.println("Found the file but it has no integers!");
                System.out.println("Testing complete. Exit program.");
                System.exit(0);
            } else {
                System.out.println("Found " + size + " integers in file. Start processing.");

                inputFile.close();
                inputFile = new Scanner(new File(fileName));

                list = new OrderedArrayList(size);
                while (inputFile.hasNext()) {
                    if (inputFile.hasNextInt()) {
                        list.insert(inputFile.nextInt());
                    } else
                        inputFile.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("--- File Not Found! Exit program! ---");
            System.exit(0);
        }

        return list;
    }

    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next(); // consume unwanted input type
            System.out.print("Not an Integer! Try again!\n");
            System.out.print(prompt);
        }
        return input.nextInt();
    }
}
