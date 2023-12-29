import java.util.*;

public class Lab2_Program1 {
    public static void main(String[] args) {
        double price;
        double salesTaxRate;
        double totalPrice;
        Scanner console = new Scanner(System.in);

        System.out.println("Enter price of item and sales tax rate: ");
        price = console.nextDouble();
        salesTaxRate = console.nextDouble();

        totalPrice = price + (price * salesTaxRate);
        System.out.print("Total Price of item: $");
        System.out.println(totalPrice);
    }
}
