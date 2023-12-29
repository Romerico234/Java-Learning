//Matrix Client
//Romerico David
//Julian Halsey
//Michael Reifer

import java.util.Scanner;

public class MatrixClient {
    public static final int MAX = 20;
    public static final int LOW = 1;
    public static final int UP = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;

        int size = getInt(input, "Please enter the size of the square matrix: ");
        while (size <= 0 || size > MAX) {
            System.out.println("Must be positive and less than "+ MAX);
            size = getInt(input, "Please enter the size of the square matrix: ");
        }

        int choice = menu();

        while (choice != 0) {

            Matrix first = new Matrix(size);
            first.init(LOW, UP);

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    Matrix second1 = new Matrix(size);
                    second1.init(LOW, UP);

                    Matrix result = null;

                    if (choice == 1)
                        result = first.add(second1);
                    else if (choice == 2)
                        result = first.subtract(second1);
                    else if (choice == 3)
                        result = first.multiply(second1);

                    System.out.println("First matrix is:");
                    first.print();

                    System.out.println("Second matrix is:");
                    second1.print();

                    System.out.println("The resulting matrix is:");
                    result.print();

                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                case 4:
                    int constant = getInt(input, "Enter the multiplication constant: ");
                    Matrix product = first.multiplyByConstant(constant);

                    System.out.println("The original matrix is:");
                    first.print();

                    System.out.println("The original matrix multiplied by " + constant + " is:");
                    product.print();

                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                case 5:
                    Matrix transposed = first.transpose();

                    System.out.println("The original matrix is:");
                    first.print();

                    System.out.println("The transposed matrix is:");
                    transposed.print();

                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                case 6:
                    System.out.println("The original matrix is:");
                    first.print();
                    System.out.println("The trace for this matrix is: " + first.trace());
                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                case 7:
                    System.out.println("The original matrix is:");
                    first.print();

                    Matrix copy = first.getCopy();
                    System.out.println("The copy of this matrix is:");
                    copy.print();

                    System.out.println("Testing for equality. Should be equal!");
                    if (first.equals(copy))
                        System.out.println("The matrices are equal!");
                    else
                        System.out.println("The matrices are NOT equal!");

                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                case 8:
                    Matrix second2 = new Matrix(size);
                    second2.init(LOW, UP);

                    System.out.println("First matrix is:");
                    first.print();

                    System.out.println("Second matrix is:");
                    second2.print();

                    if (first.equals(second2))
                        System.out.println("The matrices are equal!");
                    else
                        System.out.println("The matrices are NOT equal!");

                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                default:
                    System.out.println("Invalid range! Try again!");
                    break;
            }

            choice = menu();
        }
        System.out.println("Testing completed.");
    }

    public static int menu() {
        System.out.println("Your options are:");
        System.out.println("-----------------");
        System.out.println("\t1) Add 2 matrices");
        System.out.println("\t2) Subtract 2 matrices");
        System.out.println("\t3) Multiply 2 matrices");
        System.out.println("\t4) Multiply matrix by a constant");
        System.out.println("\t5) Transpose matrix");
        System.out.println("\t6) Matrix trace");
        System.out.println("\t7) Make a copy");
        System.out.println("\t8) Test for equality");
        System.out.println("\t0) EXIT");

        return getInt(new Scanner(System.in), "Please enter your option: ");
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
