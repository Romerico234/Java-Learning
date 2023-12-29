import java.util.*;
import java.io.*;

public class Useful_Practice {
    public static void main(String[] args) throws FileNotFoundException {
        // Practice #1:
        Scanner input = new Scanner(System.in);
        String name;
        System.out.println("Enter your name: ");
        name = input.next();
        System.out.println("Hello " + name + "!");

        // Practice #2:
        int num1, num2;
        System.out.println("Enter two integers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        int total = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + total + ".");

        // Practice #3:
        double price;
        final double SALES_TAX_RATE = 0.06;
        System.out.println("Enter a price: ");
        price = input.nextDouble();
        System.out.printf("%-15s %.2f\n%-15s %.2f\n%-15s %.2f", "Total Price:", (price * (1 + SALES_TAX_RATE)),
                "Item Price:",
                price, "Sales Tax:", (price * SALES_TAX_RATE));

        // Practice #4:
        System.out.println();
        double[] testScore = new double[3];
        double sum = 0;
        int numTests = 0;
        for (int i = 0; i < testScore.length; i++) {
            System.out.println("Enter  Test Score " + (i + 1) + ":");
            testScore[i] = input.nextDouble();
            sum = testScore[i] + sum;
            numTests++;
        }
        System.out.println("Average Test Score is: " + (sum / numTests));

        // Practice #6:
        int posSum = 0;
        int negSum = 0;
        int number;
        System.out.println("Enter an integer, 999 to quit");
        number = input.nextInt();
        while (number != 999) {
            if (number % 2 == 0) {
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }

            if (number >= 0) {
                posSum++;
            } else {
                negSum++;
            }
            System.out.println("Enter an integer, 999 to quit");
            number = input.nextInt();
        }
        System.out.println("There are " + posSum + " positive numbers and " + negSum + " negative numbers");

        // Practice #7:
        System.out.println();
        int[] num = new int[3];
        System.out.println("Enter three integers: ");
        num[0] = input.nextInt();
        num[1] = input.nextInt();
        num[2] = input.nextInt();
        int min = num[0];
        ;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        System.out.println("Smallest number is: " + min);

        // Practice #8:
        System.out.println();
        File file = new File("Test_Scores.txt");
        Scanner fileScanner = new Scanner(file);
        final int SIZE = 10;
        double totalScores = 0;
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeE = 0, gradeF = 0;
        double[] scores = new double[SIZE];
        for (int i = 0; fileScanner.hasNextInt(); i++) {
            scores[i] = fileScanner.nextInt();
            if (scores[i] >= 90) {
                gradeA++;
                System.out.println("You received an A");
            } else if (scores[i] >= 80) {
                gradeB++;
                System.out.println("You received a B");
            } else if (scores[i] >= 70) {
                gradeC++;
                System.out.println("You received a C");
            } else if (scores[i] >= 60) {
                gradeD++;
                System.out.println("You received a D");
            } else if (scores[i] >= 50) {
                gradeE++;
                System.out.println("You received an E");
            } else {
                gradeF++;
                System.out.println("You received a F");
            }
            totalScores = totalScores + scores[i];
        }
        double averageScore = totalScores / SIZE;
        if (averageScore >= 90) {
            System.out.println("Average Test Score: " + averageScore + "\nGrade: A");
        } else if (averageScore >= 80) {
            System.out.println("Average Test Score: " + averageScore + "\nGrade: B");
        } else if (averageScore >= 70) {
            System.out.println("Average Test Score: " + averageScore + "\nGrade: C");
        } else if (averageScore >= 60) {
            System.out.println("Average Test Score: " + averageScore + "\nGrade: D");
        } else if (averageScore >= 50) {
            System.out.println("Average Test Score: " + averageScore + "\nGrade: E");
        } else {
            System.out.println("Average Test Score: " + averageScore + "\nGrade: F");
        }

        // Practice #9:
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println("Towson University");
        }

        // Practice #10:
        int[] stuff = new int[100];
        for (int i = 0; i < stuff.length; i++) {
            stuff[i] = -1;
        }

        // Practice #11:
        System.out.println();
        int[] stuff2 = new int[5];
        int summation = 0;
        int found = 0;
        for (int i = 0; i < stuff2.length; i++) {
            System.out.println("Enter any integer for index " + (i + 1) + ":");
            stuff2[i] = input.nextInt();
            summation = summation + stuff2[i];
        }
        System.out.println("Sum of integers: " + summation);
        for (int i = (stuff2.length - 1); i >= 0; i--) {
            System.out.println(stuff2[i]);
        }
        for (int i = 0; i < stuff2.length; i++) {
            if (stuff2[i] == 6) {
                found = i;
            }
        }
        if (found != 0) {
            System.out.println("Found 6!");
        } else {
            System.out.println("Could not find 6 :(");
        }

        // Practice #12:
        System.out.println();
        int[][] junk = new int[10][20];
        for (int row = 0; row < junk.length; row++) {
            for (int col = 0; col < junk[row].length; col++) {
                junk[row][col] = 0;
                System.out.print(junk[row][col]);
            }
            System.out.println();
        }

        // Practie #13:
    }

    public double calcPerimeter(double length, double width) {
        return ((2 * length) + (2 * width));
    }

}
