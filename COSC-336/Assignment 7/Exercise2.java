/* Reference Website: 
 * https://www.geeksforgeeks.org/sort-n-numbers-range-0-n2-1-linear-time/
*/

// Java program to sort an array of size n where elements are
// in range from 0 to n^2 – 1.
class RadixSort {
	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i, count[] = new int[n];
		for (i = 0; i < n; i++)
			count[i] = 0;

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % n]++;

		// Change count[i] so that count[i] now contains actual
		// position of this digit in output[]
		for (i = 1; i < n; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % n] - 1] = arr[i];
			count[(arr[i] / exp) % n]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	// The main function to that sorts arr[] of size n using Radix Sort
	void sort(int arr[], int n) {
		// Do counting sort for first digit in base n. Note that
		// instead of passing digit number, exp (n^0 = 1) is passed.
		countSort(arr, n, 1);

		// Do counting sort for second digit in base n. Note that
		// instead of passing digit number, exp (n^1 = n) is passed.
		countSort(arr, n, n);
	}

	// A utility function to print an array
	void printArr(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}

public class Exercise2 {
	public static void main(String args[]) {
		int[] list1 = {45, 98, 3, 82, 132, 71, 72, 143, 91, 28, 7, 45};
		int[] list2 = {45, 98, 3, 82, 132, 71, 72, 143, 91, 28, 7, 45, 151, 175, 145, 399, 21, 267, 346, 292};
		sort(list1, list1.length);
		System.out.println("\n---------------------");
		sort(list2, list2.length);
	}

	public static void sort(int[] list1, int n) {
		RadixSort ob = new RadixSort();
		ob.sort(list1, n);
		ob.printArr(list1, n);
	}
}
/* This code is contributed by Rajat Mishra */
