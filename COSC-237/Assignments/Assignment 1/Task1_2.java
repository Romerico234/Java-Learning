//Romerico David
//Julian Halsey
//Michael Reifer

import java.util.*;

public class Task1_2 {
    public static final int MAX = 100;
    public static final int MIN = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        boolean flag = true;

        while (flag) {
            int size;
            int k;
            int[] list = null;

            menu();

            int option = getInt(input, "Please enter your option: ");

            switch (option) {
                case 0:
                    System.out.println("Testing completed.");
                    flag = false;
                    break;

                case 1:
                case 4:
                    size = getInt(input, "How many elements in the list?: ");
                    list = new int[size];
                    initRand(list, size, rand, MAX, MIN);
                    System.out.println("The original list is:");
                    print(list, size);
                    if (option == 1) {
                        shiftLeft(list, size);
                        System.out.println("The list after left rotation is:");
                        print(list, size);
                    } else if (option == 4) {
                        shiftRight(list, size);
                        System.out.println("The list after right rotation is:");
                        print(list, size);
                    }

                    break;

                case 2:
                case 5:
                    size = getInt(input, "How many elements in the list?: ");
                    list = new int[size];
                    initRand(list, size, rand, MAX, MIN);
                    System.out.println("The original list is:");
                    print(list, size);

                    if (option == 2) {
                        k = getInt(input, "Input k (steps for shift left): ");
                        shiftLeft(list, k, size);
                        System.out.println("The original list after left rotation with " + k + " positions is:");
                        print(list, size);
                    } else if (option == 5) {
                        k = getInt(input, "Input k (steps for shift right): ");
                        shiftRight(list, k, size);
                        System.out.println("The original list after right rotation with " + k + " positions is:");
                        print(list, size);
                    }

                    break;

                case 3:
                case 6:
                    size = getInt(input, "How many elements in the list?: ");
                    list = new int[size];
                    initRand(list, size, rand, MAX, MIN);
                    System.out.println("The original list is:");
                    print(list, size);

                    if (option == 3) {
                        k = getInt(input, "Input k (steps for shift left): ");
                        System.out.println("The second list after left rotation with " + k + " positions is:");
                        print(shiftLeftK(list, size, k), size);

                    } else if (option == 6) {
                        k = getInt(input, "Input k (steps for shift right): ");
                        System.out.println("The second list after right rotation with " + k + " positions is:");
                        print(shiftRightK(list, size, k), size);
                    }

                    break;

                default:
                    System.out.println("Invalid range! Try again!");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Your options are:");
        System.out.println("-----------------");
        System.out.println("\t1) Shift left");
        System.out.println("\t2) Shift left (k steps)/in place");
        System.out.println("\t3) Shift left (k steps)/second array");
        System.out.println("\t4) Shift right");
        System.out.println("\t5) Shift right (k steps)/in place");
        System.out.println("\t6) Shift right (k steps)/second array");
        System.out.println("\t0) EXIT");
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

    public static void print(int[] list, int size) {
        for (int i = 0; i < size; i++)
            System.out.printf("%-4d", list[i]);
        System.out.println();
    }

    public static int[] copy(int[] list, int size) {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++)
            copy[i] = list[i];
        return copy;
    }

    public static void initRand(int[] list, int size, Random rand, int max, int min) {
        for (int i = 0; i < size; i++)
            list[i] = rand.nextInt(max - min + 1) + min;
    }

    public static void shiftLeft(int[] list, int size) {
        int first = list[0];
        for (int i = 0; i < size - 1; i++) 
            list[i] = list[i + 1];
        list[size - 1] = first;
    }

    public static void shiftRight(int[] list, int size) {
        int last = list[size - 1];
        for (int i = size - 1; i > 0; i--) 
            list[i] = list[i - 1];
        list[0] = last;
    }

    public static void shiftLeft(int[] list, int size, int k) { // overloaded method
        for (int i = 0; i < k; i++)
            shiftLeft(list, size);
    }

    public static void shiftRight(int[] list, int size, int k) { // overloaded method
        for (int i = 0; i < k; i++)
            shiftRight(list, size);
    }

    public static int[] shiftLeftK(int[] list, int size, int k) {
        int[] copy = copy(list, size);
        for (int i = 0; i < k; i++)
            shiftLeft(copy, size);
        return copy;
    }

    public static int[] shiftRightK(int[] list, int size, int k) {
        int[] copy = copy(list, size);
        for (int i = 0; i < k; i++)
            shiftRight(copy, size);
        return copy;
    }

}
