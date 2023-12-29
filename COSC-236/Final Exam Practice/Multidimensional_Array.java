import java.util.*;
import java.io.*;

public class Multidimensional_Array {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        int min = 999;
        int count = 0;
        int lowRow = 0;
        int lowCol = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = (int) (Math.random() * 100); // random number between (0-99), casts to int from
                                                               // double
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();

        while (count != 3 * 3) {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[row].length; col++) {
                    if (array[row][col] < min) {
                        min = array[row][col];
                        lowRow = row;
                        lowCol = col;
                    }
                }
            }
            array[lowRow][lowCol] = 100;
            min = 999;
            count++;
        }

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }
}
