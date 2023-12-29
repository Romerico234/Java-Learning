import java.util.*;

public class Lab5 {
    public static void main(String[] args) {
        int option;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter an option from 1-4, 999 to quit:");
        if (console.hasNextInt() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        option = console.nextInt();// \n
        console.nextLine(); // removes the leftover newline

        while (((option >= 1) && (option <= 4)) && (option != 999)) {
            switch (option) {
                case 1:
                    Temperature(console);
                    break;
                case 2:
                    TestScores(console);
                    break;
                case 3:
                    Loops(console);
                    break;
                case 4:
                    Destinations(console);
                    break;
            }
            System.out.println("\nEnter an option from 1-4, 999 to quit");
            if (console.hasNextInt() == false) {
                System.out.println("That is not a valid input.");
                System.exit(0);
            }
            option = console.nextInt();
        }

        System.out.println("Exiting menu...");
    }

    public static void Temperature(Scanner console) {
        double totalTemp = 0;
        int count = 0;
        double avgTemp;
        System.out.println("Option: Temperature\nEnter a temperature in Fahrenheit from -30 to 120, 999 to quit:");
        if (console.hasNextDouble() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        double temp = console.nextDouble();

        while (((temp >= -30.0) && (temp <= 120.0)) && (temp != 999)) {
            if (temp >= 32.0) {
                System.out.println("Temperature: " + temp + " degrees Fahrenheit is above freezing.");
                totalTemp = (temp + totalTemp);
                count++;
            } else {
                totalTemp = temp + totalTemp;
                System.out.println("Temperature: " + temp + " degrees Fahrenheit is below freezing.");
                count++;
            }

            System.out.println("Enter another temperature, 999 to quit: ");
            if (console.hasNextDouble() == false) {
                System.out.println("That is not a valid input.");
                System.exit(0);
            }
            temp = console.nextDouble();
        }

        avgTemp = (double) totalTemp / count;
        System.out.printf("Average of the %d temperatures inputed are %.2f degrees Fahrenheit.\n", count, avgTemp);
    }

    public static void TestScores(Scanner console) {
        double testScore;
        int[] grade = { 0, 0, 0, 0, 0 };
        int count = 0;
        double totalGrade = 0;

        System.out.println("Option: Test Scores\nEnter a test score from 0 to 100, 999 to quit:");
        if (console.hasNextDouble() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        testScore = console.nextDouble();

        while (((testScore >= 0) && (testScore <= 100)) && (testScore != 999)) {
            if (testScore >= 90) {
                grade[0]++;
                totalGrade = totalGrade + testScore;
                count += grade[0];
            } else if (testScore >= 80) {
                grade[1]++;
                totalGrade = totalGrade + testScore;
                count += grade[1];
            } else if (testScore >= 70) {
                grade[2]++;
                totalGrade = totalGrade + testScore;
                count += grade[2];
            } else if (testScore >= 60) {
                grade[3]++;
                totalGrade = totalGrade + testScore;
                count += grade[3];
            } else {
                grade[4]++;
                totalGrade = totalGrade + testScore;
                count += grade[4];
            }
            System.out.println("Enter a test score from 0 to 100 again, 999 to quit:");
            if (console.hasNextDouble() == false) {
                System.out.println("That is not a valid input.");
                System.exit(0);
            }
            testScore = console.nextDouble();
        }
        double avgTestScores = (double) totalGrade / count;
        System.out.printf("Average of test scores is: %.2f\n", avgTestScores);
        System.out.printf(
                "Amount of A's: %-2d\nAmount of B's: %-2d\nAmount of C's: %-2d\nAmount of D's: %-2d\nAmount of E's: %-2d\n",
                grade[0], grade[1], grade[2], grade[3], grade[4]);
    }

    public static void Loops(Scanner console) {
        System.out.println("Option: Loops");

        System.out.println("Loop A");
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);

        System.out.println("\nLoop B");
        for (int j = 10; j > 0; j--) {
            System.out.println(j);
        }

        System.out.println("\nLoop C");
        int k = 2;
        while (k <= 20) {
            if (k % 2 == 0) {
                System.out.println(k);
            }
            k++;
        }

        System.out.println("\nLoop D");
        int count = 0;
        System.out.println("Hello\nDo you want to repeat Loop D? Y/N");
        if (console.hasNext() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        char answer = console.next().charAt(0);
        while ((answer == 'Y') || (answer == 'y')) {
            System.out.println("Hello\nDo you want to repeat Loop D? Y/N");
            count++;

            answer = console.next().charAt(0);
        }
        System.out.printf("You repeated Loop D %d times\n", count);

        System.out.println("\nLoop E");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void Destinations(Scanner console) {
        String[] city = new String[5];
        System.out.println("Option 4: Destinations");

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter City " + (i + 1) + ": ");
            if (console.hasNext() == false) {
                System.out.println("That is not a valid input.");
                System.exit(0);
            }
            city[i] = console.nextLine();
        }

        for (int j = 0; j < 3; j++) {
            Random random = new Random();
            int randomIndex = random.nextInt(city.length);
            String randomCity = city[randomIndex];
            System.out.println("Random City " + (j + 1) + ": " + randomCity);
        }
    }
}
