import java.io.*;
import java.util.*;

public class Assign3 {
    public static void main(String[] args) {

        int A[] = { 7, 3, 8, 1, 5 };
        int B[] = fileReader("input-3.4.txt");
        int C[] = fileReader("input-3.5.txt");

        int pairsA = mergeSort(A, 0, A.length - 1, 0);
        int pairsB = mergeSort(B, 0, B.length - 1, 0);
        int pairsC = mergeSort(C, 0, C.length - 1, 0);
        System.out.println("Number of *-pairs: " + pairsA);
        System.out.println("Number of *-pairs: " + pairsB);
        System.out.println("Number of *-pairs: " + pairsC);

    }

    /*fileReader method to read the inputs from files and assign them to an array */
    public static int[] fileReader(String fileName) { 
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            int size = 0;
            if (fileReader.hasNextInt())
                size = fileReader.nextInt();
            int[] list = new int[size];
            int i = 0;
            while (fileReader.hasNextInt())
                list[i++] = fileReader.nextInt();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return null;
    }

    public static int mergeSort(int[] A, int l, int r, int pairs) {
        if (l < r) {
            int m = l + (r - l) / 2;
            pairs = mergeSort(A, l, m, pairs);
            pairs = mergeSort(A, m + 1, r, pairs);
            pairs += merge(A, l, m, r);
        }
        return pairs;
    }

    public static int merge(int[] A, int l, int m, int r) {
        int pairs = 0;
        int nL = m - l + 1; // length of left half
        int nR = r - m; // length of right half

        int[] L = new int[nL]; // left half array
        int[] R = new int[nR]; // right half array

        for (int i = 0; i < nL; i++)
            L[i] = A[l + i]; // putting elements into left half

        for (int j = 0; j < nR; j++)
            R[j] = A[m + j + 1]; // putting elements into right half

        int i = 0;
        int j = 0;
        int k = l;

        /*
         * The loop merges the left and right halves together 
         * and calculates the number of pairs as follows:
         * If the element at the left half is less 
         * than the element at the right half,
         * then all of the following elements of the right half are
         * also greater than the current left element. 
         * So, pairs is increased by 
         * the number of remaining elements in the right array
         */

        while (i < nL && j < nR) {
            if (L[i] < R[j]) {
                pairs += R.length - j;
                A[k] = L[i++];
            } else
                A[k] = R[j++];
            k++;
        }

        /*
         * Leftover elements in either the left or right halves are
         * appended at the end of the A array
         */

        while (i < nL)
            A[k++] = L[i++];

        while (j < nR)
            A[k++] = R[j++];

        return pairs;

    }  
}