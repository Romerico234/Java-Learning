import java.net.SocketPermission;
import java.util.*;

public class Lab6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(
                "Menu:\n1. Calculator\n2. NestedLoops\n3. Board\nSelect from the menu (1 to 3), 999 to quit: ");
        if (console.hasNextInt() == false) {
            System.out.println("This is an invalid entry.");
            System.exit(0);
        }
        int option = console.nextInt();
        while (((option < 1) || (option > 3)) && (option != 999)) {
            System.out.println("Outside of range, enter again: ");
            option = console.nextInt();
        }
        while (option != 999) {
            switch (option) {
                case 1:
                    Calculator(console);
                    break;
                case 2:
                    NestedLoops(console);
                    break;
                case 3:
                    Board(console);
                    break;
            }
            System.out.println(
                    "Menu:\n1. Calculator\n2. NestedLoops\n3. Board\nSelect from the menu (1 to 3), 999 to quit: ");
            console.nextLine();
            if (console.hasNextInt() == false) {
                System.out.println("This is an invalid entry.");
                System.exit(0);
            }
            option = console.nextInt();
        }
        System.out.println("Exiting menu...");
    }

    public static void Calculator(Scanner console) {
        System.out.println("Calculator");
        System.out.printf("%-2d%-2d%-2d%-2c\n", 7, 8, 9, 'x');
        System.out.printf("%-2d%-2d%-2d%-2c\n", 4, 5, 6, '/');
        System.out.printf("%-2d%-2d%-2d%-2c\n", 1, 2, 3, '-');
        System.out.printf("%-2d%-2c%-2c%-2c\n", 0, '.', '%', '+');

        System.out.println("Enter first number, \"quit\" to exit: ");
        while (console.hasNextDouble()) {
            double input = console.nextDouble();
            System.out.println("Enter operator: ");
            if (console.hasNext() == false) {
                System.out.println("Invalid entry.");
                System.exit(0);
            }
            char operator = console.next().charAt(0);

            System.out.println("Enter second number: ");
            if (console.hasNextDouble() == false) {
                System.out.println("Invalid entry.");
                System.exit(0);
            }
            double input2 = console.nextDouble();

            if ((operator == 'X') || (operator == 'x')) {
                System.out.println(input * input2);
            } else if (operator == '/') {
                if (input2 == 0) {
                    System.out.println("Cannot divide by 0");
                } else {
                    System.out.println(input / input2);
                }
            } else if (operator == '-') {
                System.out.println(input - input2);
            } else if (operator == '+') {
                System.out.println(input + input2);
            } else if (operator == '-') {
                System.out.println(input - input2);
            } else if (operator == '%') {
                if (input2 == 0) {
                    System.out.println("Cannot divide by 0");
                } else {
                    System.out.println(input % input2);
                }
            } else {
                System.out.println("No operand");
            }
            System.out.println("Enter first number, \"quit\" to exit: ");
        }
        console.nextLine();
        System.out.println("Exiting Calculator...");
        return;
    }

    public static void NestedLoops(Scanner console) {
        System.out.println("NestedLoops");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print((j + i + 1) + " ");
            }
            System.out.println();
        }
        return;
    }

    public static void Board(Scanner console) {
        System.out.println("Board");
        final int row = 9;
        final int col = 9;
        int i_count = 4;
        int j_count = 4;
        int spaces;
        char board[][] = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == i_count) && (j == j_count)) {
                    board[i][j] = 'x';
                } else {
                    board[i][j] = '-';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Enter direction you would like to move, N S E W, \"quit\" to end: ");
        while (console.hasNext()) {
            String move = console.next();
            if ((move.equals("quit"))) {
                System.out.println("Exiting Board...");
                return;
            }
            if ((move.equals("N")) || (move.equals("n")) || (move.equals("S")) || (move.equals("s"))
                    || (move.equals("E")) || (move.equals("e")) || (move.equals("W")) || (move.equals("w"))) {
                System.out.println("Enter number of spaces you would like to move " + move + ":");
            } else {
                System.out.println("Invalid entry");
                System.exit(0);
            }

            if (console.hasNextInt() == false) {
                System.out.println("Invalid entry.");
                System.exit(0);
            }
            spaces = console.nextInt();
            if ((move.equals("N")) || (move.equals("n"))) {
                board[i_count][j_count] = '-';
                i_count = (i_count - spaces + row) % row;
                board[i_count][j_count] = 'x';

            } else if ((move.equals("S")) || (move.equals("s"))) {
                board[i_count][j_count] = '-';
                i_count = (i_count + spaces) % row;
                board[i_count][j_count] = 'x';

            } else if ((move.equals("E")) || (move.equals("e"))) {
                board[i_count][j_count] = '-';
                j_count = (j_count + spaces) % col;
                board[i_count][j_count] = 'x';

            } else if ((move.equals("W")) || (move.equals("w"))) {
                board[i_count][j_count] = '-';
                j_count = (j_count - spaces + col) % col;
                board[i_count][j_count] = 'x';
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Move by entering N S E W (North, South, West, East), \"quit\" to leave: ");
        }
    }
}
