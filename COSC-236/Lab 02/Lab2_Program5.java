import java.util.*;

public class Lab2_Program5 {
    public static void main(String[] args) {
        int num1;
        int num2;
        int sum;
        int difference;
        int product;
        int quotient;
        int remainder;
        Scanner console = new Scanner(System.in);

        System.out.println("Enter two integer numbers:");
        num1 = console.nextInt();
        num2 = console.nextInt();

        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;
        quotient = num1 / num2;
        remainder = num1 % num2;

        System.out.printf("%-15s %d%n%-15s %d%n%-15s %d%n%-15s %d%n%-15s %d%n", "Sum: ", sum, "Difference: ",
                difference, "Product: ", product, "Quotient: ", quotient, "Remainder: ", remainder);
    }
}
