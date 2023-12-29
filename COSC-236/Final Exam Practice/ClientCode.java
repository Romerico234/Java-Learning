import java.util.*;

public class ClientCode {
    public static void main(String[] args) {
        Useful_Practice object = new Useful_Practice();
        Scanner console = new Scanner(System.in);
        double length;
        double width;
        System.out.println("Enter length: ");
        length = console.nextDouble();
        System.out.println("Enter width: ");
        width = console.nextDouble();
        System.out.println("Perimeter is: " + object.calcPerimeter(length, width));
    }

}
