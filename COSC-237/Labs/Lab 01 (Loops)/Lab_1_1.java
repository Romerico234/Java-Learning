import java.util.*;

public class Lab_1_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int guess;
        boolean flag = true;
        int num_of_guesses = 0;
        int answer = rand.nextInt(99 - 10 + 1) + 10;

        System.out.println(
                "Try to guess my secret two-digit number, and I'll tell you how many digits from your guess appear in my number.");
        System.out.println("Be smart! You can try at most 10 times.");

        while (num_of_guesses < 10 && flag) {
            guess = getInt(input, "Your guess: ");
            guess = getInRange(guess, input, "Your guess ", 99, 10);

            num_of_guesses++;

            int answer_first_digit = answer / 10;
            int answer_second_digit = answer % 10;
            int guess_first_digit = guess / 10;
            int guess_second_digit = guess % 10;

            if (answer == guess)
                flag = false;
            else {
                int matchingDigits = 0;

                if (guess_first_digit == answer_first_digit || guess_first_digit == answer_second_digit)
                    matchingDigits++;

                if ((guess_first_digit != guess_second_digit) && (guess_second_digit == answer_first_digit || guess_second_digit == answer_second_digit))
                    matchingDigits++;

                if (matchingDigits == 2)
                    System.out.println("Incorrect (Hint: 2 digits match)");
                else if (matchingDigits == 1)
                    System.out.println("Incorrect (Hint: 1 digit match)");
                else
                    System.out.println("Incorrect (Hint: 0 digits match)");
            }
        }

        if (num_of_guesses == 1 && flag == false)
            System.out.printf("You guessed my number in %d try!", num_of_guesses);
        else if (num_of_guesses >= 10 && flag == true)
            System.out.printf("You failed to guess my number in %d tries! The number is %d.", num_of_guesses,
                    answer);
        else
            System.out.printf("You guessed my number in %d tries!", num_of_guesses);
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

    public static int getInRange(int guess, Scanner input, String prompt, int max, int min) {
        while (guess < min || guess > max) {
            System.out.println("Outside of range");
            guess = getInt(input, prompt);
        }
        return guess;
    }

}