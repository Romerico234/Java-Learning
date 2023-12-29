//ComplexNumber Client
//Romerico David
//Julian Halsey
//Michael Reifer

import java.util.Scanner;

public class ComplexClient {
    public static void main(String[] args) {
        int count = 0;

        ComplexNumber complexNum = new ComplexNumber();
        ComplexNumber complexNum2 = new ComplexNumber();

        int choice = menu();

        while (choice != 0) {
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    complexNum.read();
                    complexNum2.read();
                    ComplexNumber result = new ComplexNumber();
                    String symbol = "";

                    if (choice == 1) {
                        result = complexNum.add(complexNum2);
                        symbol = "+";
                    } else if (choice == 2) {
                        result = complexNum.subtract(complexNum2);
                        symbol = "-";
                    } else if (choice == 3) {
                        result = complexNum.multiply(complexNum2);
                        symbol = "*";
                    } else if (choice == 4) {
                        result = complexNum.divide(complexNum2);
                        symbol = "/";
                    }

                    System.out.println("First complex number is: " + complexNum);
                    System.out.println("Second complex number is: " + complexNum2);
                    System.out.println("Result: " + complexNum + " " + symbol + " " + complexNum2 + " = " + result);

                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                case 5:
                    complexNum.read();
                    System.out.println("The complex number is " + complexNum);
                    System.out.printf("Result: | " + complexNum + " | = %.2f\n", complexNum.cAbs());

                    System.out.println("Command number " + ++count + " completed.\n");
                    break;

                case 6:
                    complexNum.read();
                    complexNum2.read();

                    if (complexNum.equals(complexNum2))
                        System.out.println("The complex numbers are equal.");
                    else
                        System.out.println("The complex numbers are NOT equal.");

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
        System.out.println("Your options for Complex Arithmetic are:");
        System.out.println("----------------------------------------");
        System.out.println("\t1) Add 2 complex numbers");
        System.out.println("\t2) Subtract 2 complex numbers");
        System.out.println("\t3) Multiply 2 complex numbers");
        System.out.println("\t4) Divide 2 complex numbers");
        System.out.println("\t5) Absolute value of a complex number");
        System.out.println("\t6) Compare 2 complex numbers");
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