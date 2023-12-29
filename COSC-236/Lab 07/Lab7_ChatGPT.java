import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab7_ChatGPT {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. Sum, max, and average of numbers in input.txt");
            System.out.println("2. Write student records to students.dat");
            System.out.println("3. Read student records from students.dat and display selected record");
            System.out.println("4. Quit");

            // Get user input
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline character

            // Call selected problem
            switch (choice) {
                case 1:
                    Problem1();
                    break;
                case 2:
                    Problem2();
                    break;
                case 3:
                    Problem3();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        input.close();
    }

    public static void Problem1() {
        try {
            // Read from input.txt
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            // Initialize variables
            double sum = 0.0;
            double max = Double.NEGATIVE_INFINITY;
            int count = 0;

            // Calculate sum, max, and count
            while (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                sum += number;
                if (number > max) {
                    max = number;
                }
                count++;
            }

            // Calculate average
            double average = sum / count;

            // Write to output.txt
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Sum: " + sum + "\n");
            writer.write("Max: " + max + "\n");
            writer.write("Average: " + average + "\n");
            writer.close();

            System.out.println("Successfully wrote output to output.txt.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public static void Problem2() {
        try {
            // Get input from user
            Scanner input = new Scanner(System.in);
            System.out.print("How many student records do you want to enter? ");
            int numRecords = input.nextInt();
            input.nextLine(); // consume newline character

            // Write to students.dat
            FileWriter writer = new FileWriter("students.dat");
            for (int i = 1; i <= numRecords; i++) {
                System.out.println("Enter details for student " + i + ":");
                System.out.print("First name: ");
                String firstName = input.nextLine();
                System.out.print("Last name: ");
                String lastName = input.nextLine();
                System.out.print("Grade received: ");
                String grade = input.nextLine();
                System.out.print("Year taken: ");
                String year = input.nextLine();

                // Write to file
                writer.write(firstName + "," + lastName + "," + grade + "," + year + "\n");
            }
            writer.close();

            System.out.println("Successfully wrote student records to students.dat.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public static void Problem3() {
        try {
            // Read from students.dat
            File file = new File("students.dat");
            Scanner scanner = new Scanner(file);

            // Initialize arrays
            String[] firstNames = new String[100];
            String[] lastNames = new String[100];
            String[] grades = new String[100];
            String[] years = new String[100];
            int count = 0;

            // Parse data and fill arrays
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                firstNames[count] = fields[0];
                lastNames[count] = fields[1];
                grades[count] = fields[2];
                years[count] = fields[3];
                count++;
            }

            // Create menu
            Scanner input = new Scanner(System.in);
            System.out.println("Select a student to view their record:");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + firstNames[i] + " " + lastNames[i]);
            }
            System.out.print("Enter a number: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline character

            // Print selected student's record
            System.out.println("\nStudent record:");
            System.out.println("First name: " + firstNames[choice - 1]);
            System.out.println("Last name: " + lastNames[choice - 1]);
            System.out.println("Grade received: " + grades[choice - 1]);
            System.out.println("Year taken: " + years[choice - 1]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
