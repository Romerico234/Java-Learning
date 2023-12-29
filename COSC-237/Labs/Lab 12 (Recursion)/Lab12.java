import java.util.Scanner;

public class Lab12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char answer;
        
        do {
        int posNum = getPositiveInt(input, "Enter a positive integer: ");
        int base = getPositiveInt(input, "Enter a positive integer for base: ");

        System.out.println("Sum of digits for " + posNum + " is " + iterSum(posNum) + " (iterative method).");
        System.out.println("Sum of digits for " + posNum + " is " + recSum(posNum) + " (recursive method).");

        System.out.print(posNum + " in binary code is ");
        iterConvertBinary(posNum);
        System.out.print(" (iterative method).\n");

        System.out.print(posNum + " in binary code is ");
        recConvertBinary(posNum);
        System.out.print(" (recursive method).\n");

        System.out.println(
                posNum + " in base " + base + " is " + iterConvertBaseBinary(posNum, base) + " (iterative method).");

        System.out.println(
                posNum + " in base " + base + " is " + recConvertBaseBinary(posNum, base) + " (recursive method).");

        System.out.print("Do you want to continue (Y/N): ");
        answer = input.next().charAt(0);
        } while (answer == 'y' || answer == 'Y');
    }

    public static int getPositiveInt(Scanner input, String prompt) {
        int num;
        System.out.print(prompt);
        do {
            while (!input.hasNextInt()) {
                input.next(); // consume unwanted input type
                System.out.print("Not an Integer! Try again!\n");
                System.out.print(prompt);
            }
            num = input.nextInt();
            if (num < 0)
                System.out.print("Must be positive! REENTER: ");
        } while (num < 0);
        return num;
    }

    public static int iterSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int recSum(int num) {
        if (num == 0)
            return num % 10;
        else
            return num % 10 + recSum(num /= 10);
    }

    public static void iterConvertBinary(int num) {
        if (num == 0)
            System.out.println("0");
        else {
            String binaryNum = "";
            while (num != 0) {
                if (num % 2 == 1)
                    binaryNum = 1 + binaryNum;
                else if (num % 2 == 0)
                    binaryNum = 0 + binaryNum;
                num /= 2;
            }
            System.out.print(binaryNum);
        }
    }
 
    public static void recConvertBinary(int num) {
        if (num > 1)
            recConvertBinary(num / 2);
        System.out.print(num % 2);
    }

    public static String iterConvertBaseBinary(int num, int base) {
        if (num == 0)
            return "0";
        String result = "";
        while (num != 0) {
            result = num%base + result;
            num /= base;
        }
        return result;
    }

    public static String recConvertBaseBinary(int num, int base) {
        if (num >= base) 
            return recConvertBaseBinary(num / base, base) + (num % base);
        else
            return Integer.toString(num);
    }   
}