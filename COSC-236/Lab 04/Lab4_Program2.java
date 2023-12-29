import java.util.*;

public class Lab4_Program2 {
    public static void main(String[] args) {
        String[][] board = new String[3][3];
        board[0][0] = "1";
        board[0][1] = "2";
        board[0][2] = "3";
        board[1][0] = "4";
        board[1][1] = "5";
        board[1][2] = "6";
        board[2][0] = "7";
        board[2][1] = "8";
        board[2][2] = "9";

        printBoard(board);

        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number to select a square:");
            int choice = console.nextInt();

            if (choice < 1 || choice > 9) {
                System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                continue;
            }

            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            if (!board[row][col].equals("X")) {
                board[row][col] = "X";
                printBoard(board);
            } else {
                System.out.println("That square is already taken. Please try again.");
            }
        }
    }

    public static void printBoard(String[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("-----");
            }
        }
    }
}
