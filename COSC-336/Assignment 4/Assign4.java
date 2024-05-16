/*THE ONLY INCORRECT CODE OF THESE ASSIGNMENTS IN THIS REPOSITORY */

import java.io.*;
import java.util.*;

public class Assign4 {
    // Driver code
    public static void main(String[] args) {
        int a[] = fileReader("input-4.1.txt");
        int b[] = fileReader("input-4.2.txt");
        int c[] = fileReader("input-4.3.txt");
        int d[] = fileReader("input-4.4.txt");

        System.out.println(getMaxArea(a, a.length, ((a.length) / 4) - 1)); // 3rd parameter is the number of rectangles
        System.out.println(getMaxArea(b, b.length, ((b.length) / 4) - 1));
        System.out.println(getMaxArea(c, c.length, ((c.length) / 4) - 1));
        System.out.println(getMaxArea(d, d.length, ((d.length) / 4) - 1));
    }

    public static int[] fileReader(String fileName) {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            int size = 0;
            if (fileReader.hasNextInt())
                size = fileReader.nextInt() * 2;
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

    // method that finds the max area under a histogram 
    // given an array of coordinates of rectangles
    public static int getMaxArea(int hist[], int total, int n) {
        // Stack to keep track of indices, 'total' represents the number of elements, and 'n' is the number of rectangles
        Stack<Integer> s = new Stack<>();

        // Arrays to store areas, heights, and lengths of each rectangle
        int[] areas = new int[n];
        int[] heights = new int[n];
        int[] lengths = new int[n];

        int max_area = 0;
        int tp; // To store the index of the top of the stack
        int area_with_top; // To store the area with top bar as the smallest bar

        // Calculating the area, height, and length of each rectangle then storing them in the respective arrays
        for (int i = 0; i < n; i++) {
            areas[i] = ((hist[4 + (4 * i)] - hist[2 + (4 * i)]) * (hist[3 + (4 * i)]));
            heights[i] = (hist[3 + (4 * i)]);
            lengths[i] = (hist[4 + (4 * i)] - hist[2 + (4 * i)]);
        }

        int i = 0;
        while (i < n) {
            // If the rectangle is taller or equal to the top bar, then push its index onto the stack
            if (s.empty() || heights[s.peek()] <= heights[i])
                s.push(i++);
            /*
             * If the rectangle is shorter than the top bar, 
             * then calculate the area of the rectangle with the top as the smallest rectangle
             * 'i' is the right index for the top and the element before the top is the left index
             */
            else {
                tp = s.peek();
                s.pop();

                // Calculate the area with the rectangle at index 'tp' as the smallest rectangle
                // If the stack is empty, multiply height by the x-value of the rightmost vertex
                // Otherwise, subtract the x-values of the rightmost and leftmost vertices
                // (rightmost vertex - leftmost vertex)
                
                area_with_top = heights[tp]
                        * (s.empty() ? hist[2 + (4 * i)] : hist[2 + (4 * i)] - hist[4 + (4 * s.peek())]);
        
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }
        
        // Pop the remaining rectangles from the stack 
        // and calculate the area with every popped rectangle as the smallest rectangle
        while (s.empty() == false) {
            tp = s.peek();
            s.pop();

            // Same idea and calculation from previous loop
            area_with_top = heights[tp]
                    * (s.empty() ? (hist[2 + (4 * i)] - hist[0]) : hist[2 + (4 * i)] - hist[4 + (4 * s.peek())]);
            if (max_area < area_with_top)
                max_area = area_with_top;
        }
        return max_area;
    }
}