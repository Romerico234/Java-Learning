import java.util.*;
import java.io.*;

public class Lab8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int option;
        System.out.println(
                "Menu:\n1. Get String\n2. Get Int\n3. Between Two Ints\n4. Get Double\n5. Between Two Doubles\n6. Mad Lib\nSelect from the menu (1 to 6), 999 to quit: ");
        while (!console.hasNextInt()) {
            System.out.println("This is an invalid entry, enter again: ");
            console.nextLine();
        }
        option = console.nextInt();
        console.nextLine();
        while (((option < 1) || (option > 6)) && (option != 999)) {
            System.out.println("Outside of range, enter again: ");
            option = console.nextInt();
        }
        while (option != 999) {
            switch (option) {
                case 1:
                    String name = getString(console, "Enter a name:");
                    System.out.println("You printed: " + name);
                    break;
                case 2:
                    int num = getInt(console, "Enter an int:");
                    System.out.println("You printed: " + num);
                    break;
                case 3:
                    int x = 1;
                    int y = 100;
                    betweenIntXY(console, "Enter an int: ", x, y);
                    break;
                case 4:
                    getDouble(console, "Enter a double: ");
                    break;
                case 5:
                    double a = 20.03;
                    double b = 1050.23;
                    betweenDoubleAB(console, "Enter a double: ", a, b);
                    break;
                case 6:
                    madLib(console);
                    break;
            }
            System.out.println(
                    "Menu:\n1. Get String\n2. Get Int\n3. Between Two Ints\n4. Get Double\n5. Between Two Doubles\n6. Method 6\nSelect from the menu (1 to 6), 999 to quit: ");
            while (!console.hasNextInt()) {
                System.out.println("This is an invalid entry, enter again: ");
                console.nextLine();
            }
            option = console.nextInt();
            console.nextLine();
        }
        System.out.println("Exiting menu...");
    }

    public static String getString(Scanner console, String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    public static int getInt(Scanner console, String prompt) {
        int response;
        System.out.println(prompt);
        while (!console.hasNextInt()) {
            System.out.println("Invalid entry, enter again: ");
            console.nextLine();
        }
        response = console.nextInt();
        return response;
    }

    public static int betweenIntXY(Scanner console, String prompt, int x, int y) {
        int validNum = getInt(console, prompt);
        while ((validNum < x) || (validNum > y)) {
            System.out.println("Number is not between " + x + " and " + y);
            validNum = getInt(console, prompt);
        }
        return validNum;

    }

    public static double getDouble(Scanner console, String prompt) {
        double response;
        System.out.println(prompt);
        while (!console.hasNextDouble()) {
            System.out.println("Invalid entry, enter again: ");
            console.nextLine();
        }
        response = console.nextDouble();
        return response;

    }

    public static double betweenDoubleAB(Scanner console, String prompt, double a, double b) {
        double validNum = getDouble(console, prompt);
        while ((validNum < a) || (validNum > b)) {
            System.out.println("Number is not between " + a + " and " + b);
            validNum = getDouble(console, prompt);
        }
        return validNum;
    }

    public static void madLib(Scanner console) {
        Random random = new Random();
        String itemName = getString(console, "Enter a name of an item: ");
        String color = getString(console, "Enter a color: ");
        String diffColor = getString(console, "Enter a different color: ");
        int maxNum = getInt(console, "Enter max number of " + diffColor + " " + itemName + " someone can have: ");
        int minNum = getInt(console, "Enter min number of " + diffColor + " " + itemName + " someone can have: ");
        double maxPrice = getDouble(console,
                "Enter max price of " + diffColor + " " + itemName + " someone can have: ");
        double minPrice = getDouble(console,
                "Enter min price of " + diffColor + " " + itemName + " someone can have: ");
        int randomNum = random.nextInt(minNum, maxNum);
        String prompt = "The system has " + randomNum + " " + diffColor + " " + itemName
                + ". How many would you like to buy?:";
        int totalAmount = betweenIntXY(console, prompt, minNum, randomNum);
        String promptTwo = "How much do you want to pay for 1 " + diffColor + " " + itemName + "?";
        double pricePerItem = betweenDoubleAB(console, promptTwo, minPrice, maxPrice);
        double totalPrice = totalAmount * pricePerItem;
        System.out.println(
                "You are purchasing " + totalAmount + " " + diffColor + " " + itemName + " for $" + pricePerItem
                        + " each. Your total pay is: $" + totalPrice);

    }
}
