/*
 * Our algorithm determines the maximum sum of increasing subsequences for a given integer array through
 * dynamic programming. We initialize two arrays: s[0...n] to store the maximum sum of an increasing 
 * subsequence ending at each index i, and p[0...n] to store the index of the preceding element in 
 * that subsequence. Since the only increasing subsequence that can be formed at the first element
 * is just itself with no predecessor, s[0] = a[0] and p[0] = -1. Then, we iterate through the entire 
 * array, updating s[i] and p[i] as we determine the maximum sum at each index. After we find all
 * values of s[0...n], we find the index of the maximum sum in s[0...n], which serves as a 
 * reference point to reconstruct the increasing subsequence by iterating backwards through p[0...n]. 
 */

import java.util.*;
import java.io.*;

public class Assign5 {
    public static void main(String[] args) {
        int a[] = fileReader("input-5.1.txt");
        int b[] = fileReader("input-5.2.txt");
        int c[] = fileReader("input-5.3.txt");
        int d[] = fileReader("input-5.4.txt");

        System.out.println("Max Sum: " + maxSumLIS(a));
        System.out.println("Max Sum: " + maxSumLIS(b));
        System.out.println("Max Sum: " + maxSumLIS(c));
        System.out.println("Max Sum: " + maxSumLIS(d));
    }

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

    public static int maxSumLIS(int[] a) {
        if (a.length == 0)
            return 0;

        int n = a.length;
        int[] s = new int[n]; // Array to store maximum sum of an increasing subsequence ending at index i
        int[] p = new int[n]; // Array to store the index of the element preceding a[i] in an increasing
                              // subsequence with max sum and last element a[i]

        // base cases: at index 0, s[0] = a[0] and there is no predecessor so p[0] = -1
        s[0] = a[0];
        p[0] = -1;

        // Computing the maximum sum of an increasing subsequence ending at each index i and
        // updating predecessors accordingly
        for (int i = 1; i < n; i++) {
            s[i] = a[i];
            p[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j] && s[i] <= s[j] + a[i]) {
                    s[i] = s[j] + a[i];
                    p[i] = j; 
                }
            }
        }

        // Finding the index of the maximum sum of the increasing subsequences
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] > s[maxIndex])
                maxIndex = i;
        }

        // Constructing the increasing subsequence of the maximum sum
        int[] subsequence = new int[n];
        int subIndex = 0;
        for (int i = maxIndex; i != -1; i = p[i])
            subsequence[subIndex++] = a[i];

        // Test print to show the increasing subsequence with the maximum sum 
        // (can comment out)
        System.out.print("Increasing subsequence with the maximum sum: ");
        for (int i = subIndex - 1; i >= 0; i--)
            System.out.print(subsequence[i] + " ");
        System.out.println();

        return s[maxIndex];
    }
}