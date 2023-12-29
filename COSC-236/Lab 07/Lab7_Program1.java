import java.util.*;
import java.io.*;

public class Lab7_Program1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println(
                "Menu:\n1. File\n2. Student Records\n3. Access Student's Record\nSelect from the menu (1 to 3), 999 to quit: ");
        if (console.hasNextInt() == false) {
            System.out.println("This is an invalid entry.");
            System.exit(0);
        }
        int option = console.nextInt();
        while (((option < 1) || (option > 3)) && (option != 999)) {
            System.out.println("Outside of range, enter again: ");
            option = console.nextInt();
        }
        while (option != 999) {
            switch (option) {
                case 1:
                    TextFile();
                    break;
                case 2:
                    StudentRecords();
                    break;
                case 3:
                    AccessStudentRecords();
                    break;
            }
            System.out.println(
                    "Menu:\n1. File\n2. Student Records\n3. Access Student's Record\nSelect from the menu (1 to 3), 999 to quit: ");
            console.nextLine();
            if (console.hasNextInt() == false) {
                System.out.println("This is an invalid entry.");
                System.exit(0);
            }
            option = console.nextInt();
        }
        System.out.println("Exiting menu...");
    }

    public static void TextFile() throws FileNotFoundException {
        final int SIZE = 8;
        double[] fileCount = new double[SIZE];
        double sum = 0;
        double max = 0;
        double avg;
        int count = 0;
        Scanner inputFile = new Scanner(new File("input.txt"));
        PrintStream outputFile = new PrintStream(new File("output.txt"));

        for (int i = 0; i < SIZE; i++) {
            if (inputFile.hasNextDouble()) {
                fileCount[i] = inputFile.nextDouble();
                sum += fileCount[i];
                count++;
                if (fileCount[i] > max) {
                    max = fileCount[i];
                }
            }
        }
        avg = sum / (double) count;
        outputFile.printf("%-7s %-5.2f\n%-7s %-5.2f\n%-7s %-5.2f\n", "Sum:", sum, "Average:", avg, "Max:", max);
    }

    public static void StudentRecords() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        File file = new File("students.dat");
        PrintStream outputFile = new PrintStream(file);
        int numStudents;
        System.out.println("How many students records do you want?");
        while (!console.hasNextInt()) {
            System.out.println("Invalid entry, enter again");
            console.nextLine();
        }
        numStudents = console.nextInt();

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter first name for student " + (i + 1) + ": ");
            String firstName = console.next();
            outputFile.printf("%-10s\n", firstName);
            System.out.println("Enter last name for student " + (i + 1) + ": ");
            String lastName = console.next();
            outputFile.printf("%-10s\n", lastName);
            System.out.println("Enter grade received for the course: ");
            char grade = console.next().charAt(0);
            outputFile.printf("%-10c\n", grade);
            System.out.println("Enter the year course was taken: ");
            console.nextLine();
            while (!console.hasNextInt()) {
                System.out.println("Invalid entry, enter again");
                console.nextLine();
            }
            int year = console.nextInt();
            outputFile.printf("%-10d\n", year);
        }
    }

    public static void AccessStudentRecords() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Scanner console = new Scanner(new File("students.dat"));
        int numStudents = 0;
        for (int lineNumber = 0; console.hasNextLine(); lineNumber++) {
            console.nextLine();
            if ((lineNumber + 1) % 4 == 0) {
                numStudents++;
            }
        }
        console.close();
        Scanner inputFile = new Scanner(new File("students.dat"));
        String[] firstName = new String[numStudents];
        String[] lastName = new String[numStudents];
        char[] grade = new char[numStudents];
        int[] year = new int[numStudents];
        int choice;

        for (int i = 0; i < numStudents; i++) {
            firstName[i] = inputFile.next();
            lastName[i] = inputFile.next();
            grade[i] = inputFile.next().charAt(0);
            year[i] = inputFile.nextInt();
        }

        System.out.println("Choose student:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println((i + 1) + ". " + firstName[i] + " " + lastName[i]);
        }
        choice = scanner.nextInt();
        for (int i = 0; i < numStudents; i++) {
            if ((choice - 1) == i) {
                System.out.printf("First Name: %-10s\nLast Name: %-10s\nGrade: %-10c\nYear: %-10s\n", firstName[i],
                        lastName[i], grade[i], year[i]);
            }
        }

    }
}