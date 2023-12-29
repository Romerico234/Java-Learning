import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Task3_4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Please input the name of the file to be opened for the first list: ");
        ArrayList<Integer> list1 = retrieveFromFile(input.next());

        System.out.print("Please input the name of the file to be opened for the second list: ");
        ArrayList<Integer> list2 = retrieveFromFile(input.next());

        System.out.println("The first list is: ");
        System.out.println(list1);

        System.out.println("The second list is: ");
        System.out.println(list2);

        System.out.println("The merged list is: ");
        ArrayList<Integer> result = merge(list1, list2);
        System.out.println(result);

        System.out.println("The merged list sorted is: ");
        bubbleSort(result);
        System.out.println(result);

        int key = getInt(input, "Enter key for split: ");
        split(result, list1, list2, key);
        System.out.println("The first list after split is: ");
        System.out.println(list1);
        System.out.println("The second list after split is: ");
        System.out.println(list2);
    }

    public static ArrayList<Integer> retrieveFromFile(String fileName) {
        int size = 0;
        ArrayList<Integer> list = null;
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

                list = new ArrayList<Integer>();
                while (inputFile.hasNext()) {
                    if (inputFile.hasNextInt()) {
                        list.add(inputFile.nextInt());
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

    public static ArrayList<Integer> merge(ArrayList<Integer> first, ArrayList<Integer> second){
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.addAll(first);
        result.addAll(second);
        return result;
    } 

    public static void split(ArrayList<Integer> mergedList, ArrayList<Integer> first, ArrayList<Integer> second, int key){
        first.clear();
        second.clear();
        for (int i = 0; i < mergedList.size(); i++){
            if (mergedList.get(i) < key)
                first.add(mergedList.get(i));
            else   
                second.add(mergedList.get(i));
        }
    }

    public static void bubbleSort(ArrayList<Integer> list) {
        for (int pass = 0; pass < list.size() - 1; pass++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
    }
}
