import java.util.Random;
import java.util.Scanner;

public class Lab3_1{
    public static final int MAX = 100;
    public static final int MIN = 1;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        char answer;

        System.out.print("Start (Y/N)? ");
        answer = input.next().charAt(0);

        while (answer == 'y' || answer == 'Y'){
            int size = getInt(input, "How many elements in the list: ");
            int[] list = new int[size];
            initRand(list, size, rand, MAX, MIN);

            System.out.println("The original array is: ");
            print(list, size);

            System.out.println("The second array is: ");
            print(twice(list, size), size*2);

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

    public static void initRand(int[] list, int size, Random rand, int max, int min) {
        for (int i = 0; i < size; i++)
            list[i] = rand.nextInt(max - min + 1) + min;
    }

    public static void print(int[] list, int size) {
        for (int i = 0; i < size; i++)
            System.out.printf("%-4d", list[i]);
        System.out.println();
    }

    public static int[] twice(int[] list, int size){
        int[] result = new int[size * 2];
        int index = 0;
        for (int i = 0; i < size; i++){
            result[index++] = list[i];
            result[index++] = list[i];
        }
        return result;
    }
}