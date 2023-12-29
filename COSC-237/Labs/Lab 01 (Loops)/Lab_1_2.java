import java.util.*;

public class Lab_1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        char answer;

        System.out.println("Do you want to start (Y/N)");
        answer = input.next().charAt(0);
        while (answer == 'Y' || answer == 'y') {
            size = getInt(input, "How many chars/last row? ");

            size = getInRange(size, input, "How many chars/last row? ", 21, 5);

            System.out.println("What character? ");
            char symbol = input.next().charAt(0);

            for (int i = 0; i < size; i++)
                System.out.print(symbol);
            System.out.println();

            for (int i = 0; i < size - 2; i++) {
                System.out.print(symbol);
                for (int j = 0; j < size - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print(symbol);
                System.out.println();
            }

            for (int i = 0; i < size; i++)
                System.out.print(symbol);
            System.out.println();

            System.out.println("Do you want to continue (Y/N)");
            answer = input.next().charAt(0);
        }
    }

    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);

        while (!input.hasNextInt()) {
            input.next(); // Consume unwanted input type
            System.out.print("Not an Integer! Try again!\n");
            System.out.print(prompt);
        }

        return input.nextInt();

    }

    public static int getInRange(int size, Scanner input, String prompt, int max, int min) {
        while (size < min || size > max) {
            System.out.println("ERROR! Valid Range is between 5 - 21.");
            size = getInt(input, prompt);
        }

        return size;

    }
}
