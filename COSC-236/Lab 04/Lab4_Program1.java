import java.util.*;

public class Lab4_Program1 {
    public static void main(String[] args) {
        int studentRecords;
        String[] studentName = new String[5];
        char[] studentGrade = new char[5];
        Scanner console = new Scanner(System.in);

        System.out.println("Enter student records desired (max of 5): ");
        if (console.hasNextInt() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        studentRecords = console.nextInt();
        console.nextLine();
        if (studentRecords > 5) {
            System.out.println("This exceeds the limit.");
            System.exit(0);
        }

        for (int i = 0; i < studentRecords; i++) {
            System.out.println("Enter Student " + (i + 1) + " first and last name: ");
            studentName[i] = console.nextLine();

            System.out.println("Enter grade of Student " + (i + 1) + ": ");
            studentGrade[i] = console.next().charAt(0);
            console.nextLine();
        }
        System.out.printf("%-25s %-5s\n%-25s %-5s\n", "Student", "Grade", "--------------------", "-----");

        for (int i = 0; i < studentRecords; i++) {
            System.out.printf("%-25s %-5c\n", studentName[i], studentGrade[i]);
        }

    }

}