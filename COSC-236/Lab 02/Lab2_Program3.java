import java.util.*;

public class Lab2_Program3 {
    public static void main(String[] args) {
        double price1;
        double price2;
        double price3;
        double price4;
        double price5;
        double subTotal;
        final double SALESTAXRATE = 0.06;
        double totalPrice;
        Scanner console = new Scanner(System.in);

        System.out.println("Enter prices of five items");
        price1 = console.nextDouble();
        price2 = console.nextDouble();
        price3 = console.nextDouble();
        price4 = console.nextDouble();
        price5 = console.nextDouble();

        subTotal = price1 + price2 + price3 + price4 + price5;
        totalPrice = subTotal + (subTotal * SALESTAXRATE);
        System.out.printf("%-12s$%.2f%n%-12s$%.2f%n", "Sub-total: ", subTotal, "Total: ", totalPrice);
    }
}