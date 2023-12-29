import java.util.*;

public class Lab_2_1 {
    public static final int MIN = 1;
    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int size = getInt(input, "How many elements in the list: ");
        int[] list = new int[size];

        initRand(list, size, rand, MAX, MIN);

        boolean flag = true;

        while (flag) {

            menu();

            int answer = getInt(input, "Please enter your option: ");

            switch (answer) {
                case 0:
                    System.out.println("Testing completed.");
                    flag = false;
                    break;

                case 1:
                    if (isAllEven(list, size))
                        System.out.println("All the values in the list are even");
                    else
                        System.out.println("Some of the values in the list are odd.");
                    break;

                case 2:
                    if (isUnique(list, size))
                        System.out.println("All the values are unique");
                    else
                        System.out.println("Some of the values appear multiple times.");
                    break;

                case 3:
                    System.out.println("The minimum gap between 2 adjacent values is " + minGap(list, size));
                    break;

                case 4:
                    print(list, size);
                    System.out.printf("The mean for this list is: %.2f\n", getMean(list, size));
                    System.out.printf("The variance for this list is: %.2f\n", getVariance(list, size));
                    System.out.printf("The standard deviation for this list is: %.2f\n", (Math.sqrt(getVariance(list, size))));
                    break;

                case 5:
                    top_20(list, size);
                    break;

                default:
                    System.out.println("Invalid range! Try again!");
                    break;
            }
        }
    }

    public static void menu() {
            System.out.println("Your options are: ");
            System.out.println("------------------");
            System.out.println("0) EXIT");
            System.out.println("1) All even values?");
            System.out.println("2) All unique values?");
            System.out.println("3) Print min gap between values");
            System.out.println("4) Statistics");
            System.out.println("5) Print 80% percentile");
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

    public static void initRand(int[] list, int size, Random rand, int max, int min) {
        for (int i = 0; i < size; i++)
            list[i] = rand.nextInt(max - min + 1) + min;
    }

    public static void print(int[] list, int size) {
        for (int i = 0; i < size; i++)
            System.out.printf("%-4d", list[i]);
        System.out.println();
    }

    public static boolean isAllEven(int[] list, int size) {
        for (int i = 0; i < size; i++) {
            if (list[i] % 2 != 0)
                return false;
        }
        return true;
    }

    public static boolean isUnique(int[] list, int size) {
        int[] copy = copy(list, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j != i && copy[j] == list[i])
                    return false;
            }
        }
        return true;
    }

    public static int minGap(int[] list, int size) {
        int min = list[0];
        for (int i = 1; i < size; i++) {
            if ((list[i] - list[i - 1]) < min)
                min = list[i] - list[i - 1];
        }
        return min;
    }

    public static void bubbleSort(int[] list, int size) {
        int helper;
        for (int pass = 0; pass < size - 1; pass++) { // passes
            for (int i = 0; i < size - 1; i++) { // one pass
                if (list[i] > list[i + 1]) { // one comparison
                    helper = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = helper;
                }
            }
        }
    }

    public static int[] copy(int[] list, int size) {
        int[] copy = new int[size];

        for (int i = 0; i < size; i++)
            copy[i] = list[i];

        return copy;
    }

    public static double getMean(int[] list, int size) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += list[i];
        }
        return sum / size;
    }

    public static void top_20(int[] list, int size) {
        int[] copy = copy(list, size);

        bubbleSort(copy, size);
        System.out.println("The list sorted: ");
        print(copy, size);
        
        System.out.println("80th-percentile of this list:");
        for (int i = size-1; i >= (int)(size-size*20/100); i--)
            System.out.printf("%-4d", copy[i]);
        System.out.println();
    }

    public static double getVariance(int[] list, int size) {
        double[] copy = new double[size];
        double mean = getMean(list, size);
        double variance = 0;

        for (int i = 0; i<size; i++){
            copy[i] = Math.pow((list[i]-mean),2);
        }

        for (int i = 0; i<size; i++)
            variance += copy[i];
        
        return variance / size;
    }

}
