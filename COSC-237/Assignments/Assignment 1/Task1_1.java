//Romerico David
//Julian Halsey
//Michael Reifer

import java.util.*;

public class Task1_1 {
    public static final int MAX = 10;
    public static final int MIN = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int count = 0;
        boolean flag = true;

        while (flag) {
            menu();
            int option = getInt(input, "Please enter your option: ");
            int size;
            int[][] listA = null;
            int[][] listB = null;

            switch (option) {
                case 0:
                    System.out.println("Testing completed.");
                    flag = false;
                    break;

                case 1:
                case 2:
                case 3:
                    size = getInt(input, "Please enter the size of the square matrix: ");
                    while (size <= 0) {
                        System.out.println("Must be positive and greater than 0");
                        size = getInt(input, "Please enter the size of the square matrix: ");
                    }
                    listA = generateMatrix(size, rand, MAX, MIN);
                    listB = generateMatrix(size, rand, MAX, MIN);
                    int[][] result = null;

                    if (option == 1)
                        result = addMatrices(listA, listB, size);
                    else if (option == 2)
                        result = subtractMatrices(listA, listB, size);
                    else if (option == 3)
                        result = multiplyMatrices(listA, listB, size);

                    System.out.println("First matrix is:");
                    print(listA, size);
                    System.out.println("Second matrix is:");
                    print(listB, size);

                    System.out.println("The resulting matrix is:");
                    print(result, size);

                    System.out.println("Command number " + ++count + " completed.");
                    break;

                case 4:
                    size = getInt(input, "Please enter the size of the square matrix: ");
                    while (size <= 0) {
                        System.out.println("Must be positive and greater than 0");
                        size = getInt(input, "Please enter the size of the square matrix: ");
                    }
                    int constant = getInt(input, "Enter the multiplication constant: ");
                    listA = generateMatrix(size, rand, MAX, MIN);
                    int[][] productByConst = multiplyMatrixByConst(listA, size, constant);

                    System.out.println("The matrix is:");
                    print(listA, size);

                    System.out.println("The original matrix multiplied by " + constant + " is:");
                    print(productByConst, size);

                    System.out.println("Command number " + ++count + " completed.");
                    break;

                case 5:
                    size = getInt(input, "Please enter the size of the square matrix: ");
                    while (size <= 0) {
                        System.out.println("Must be positive and greater than 0");
                        size = getInt(input, "Please enter the size of the square matrix: ");
                    }
                    listA = generateMatrix(size, rand, MAX, MIN);
                    int[][] transposeMatrix = transposeMatrix(listA, size);

                    System.out.println("The matrix is:");
                    print(listA, size);

                    System.out.println("The transposed matrix is:");
                    print(transposeMatrix, size);

                    System.out.println("Command number " + ++count + " completed.");
                    break;

                case 6:
                    size = getInt(input, "Please enter the size of the square matrix: ");
                    while (size <= 0) {
                        System.out.println("Must be positive and greater than 0");
                        size = getInt(input, "Please enter the size of the square matrix: ");
                    }
                    listA = generateMatrix(size, rand, MAX, MIN);

                    System.out.println("The matrix is:");
                    print(listA, size);

                    System.out.println("The trace for this matrix is: " + getTraceMatrix(listA, size));
                    System.out.println("Command number " + ++count + " completed.");
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
        System.out.println("\t1) Add 2 matrices");
        System.out.println("\t2) Subtract 2 matrices");
        System.out.println("\t3) Multiply 2 matrices");
        System.out.println("\t4) Multiply matrix by a constant");
        System.out.println("\t5) Transpose matrix");
        System.out.println("\t6) Matrix trace");
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

    public static int[][] generateMatrix(int size, Random rand, int max, int min) {
        int[][] list = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)
                list[row][col] = rand.nextInt(max - min + 1) + min;
        }
        return list;
    }

    public static void print(int[][] list, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)
                System.out.printf("%-4d", list[row][col]);
            System.out.println();
        }
    }

    public static int[][] addMatrices(int[][] listA, int[][] list2, int size) {
        int[][] sum = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)
                sum[row][col] = listA[row][col] + list2[row][col];
        }
        return sum;
    }

    public static int[][] subtractMatrices(int[][] listA, int[][] listB, int size) {
        int[][] difference = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)
                difference[row][col] = listA[row][col] - listB[row][col];
        }
        return difference;
    }

    public static int[][] multiplyMatrices(int[][] listA, int[][] listB, int size) {
        int[][] product = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (int i = 0; i < size; i++)
                    product[row][col] += listA[row][i] * listB[i][col];
            }
        }
        return product;
    }

    public static int[][] multiplyMatrixByConst(int[][] list, int size, int constant) {
        int[][] product = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)
                product[row][col] = list[row][col] * constant;
        }
        return product;
    }

    public static int[][] transposeMatrix(int[][] list, int size) {
        int[][] transposedMatrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                transposedMatrix[row][col] = list[col][row];
            }
        }
        return transposedMatrix;
    }

    public static int getTraceMatrix(int[][] list, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++)
            trace += list[i][i];
        return trace;
    }

}