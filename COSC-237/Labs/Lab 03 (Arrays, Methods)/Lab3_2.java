import java.util.Random;
import java.util.Scanner;

public class Lab3_2 {
    public static final int MAX = 1;
    public static final int MIN = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        char answer;

        System.out.print("Start (Y/N)? ");
        answer = input.next().charAt(0);

        while (answer == 'y' || answer == 'Y') {
            int row = getInt(input, "How many rows: ");
            int col = getInt(input, "How many columns: ");
            int[][] matrix = new int[row][col];
            initRand(matrix, rand, MAX, MIN);

            System.out.println("The matrix is:");
            print(matrix);

            boolean flag;
            int count = 0;
            for (int r1 = 0; r1 < matrix.length; r1++) {
                for (int r2 = r1 + 1; r2 < matrix.length; r2++) { 
                    flag = flipped(matrix[r1], matrix[r2]);
                    if (flag){
                        count++;
                        System.out.println("Rows index " + r1 + " and " + r2 + " are flipped.");
                    }
                }
            }

            if (count == 0)
                System.out.println("No flipped rows in this matrix.");

            System.out.print("Continue (Y/N)? ");
            answer = input.next().charAt(0);
        }

    }

    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next(); // consume unwanted input type
            System.out.print("Not an Integer! Try again!\n");
            System.out.print(prompt);
        }
        return input.nextInt();
    }

    public static void initRand(int[][] matrix, Random rand, int max, int min) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = rand.nextInt(max - min + 1) + min;
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("[%d]", i);
            for (int j = 0; j < matrix[i].length; j++)
                System.out.printf("%4d", matrix[i][j]);
            System.out.println();
        }
    }

    public static boolean flipped(int[] r1, int[] r2) {
        for (int i = 0; i < r1.length; i++) {
            if (r1[i] != flip(r2[i]))
                return false;
        }
        return true;
    }

    public static int flip(int element) {
        if (element == 0)
            return 1;
        else
            return 0;
    }
}