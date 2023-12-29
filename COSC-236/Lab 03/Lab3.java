import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int credits;
        int semesters;
        double totalCredits;
        double gradePointAvg;

        System.out.println("Enter credits taken each semester: ");
        if (console.hasNextDouble() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        credits = console.nextInt();

        System.out.println("Enter total semesters taken: ");
        if (console.hasNextInt() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        semesters = console.nextInt();
        totalCredits = (double) (semesters * credits);

        System.out.println("Enter GPA: ");
        if (console.hasNextDouble() == false) {
            System.out.println("That is not a valid input.");
            System.exit(0);
        }
        gradePointAvg = console.nextDouble();

        switch (credits) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("You are less than half-time");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("You are half-time");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("You are three-quarter time");
                break;
            default:
                System.out.println("You are full-time");
                break;
        }

        if ((totalCredits >= 0) && (totalCredits <= 29.5)) {
            System.out.println("You are a freshman.");
        } else if ((totalCredits >= 30) && (totalCredits <= 59.5)) {
            System.out.println("You are a sophomore.");
        } else if ((totalCredits >= 60) && (totalCredits <= 89.5)) {
            System.out.println("You are a junior.");
        } else {
            System.out.println("You are a senior.");
        }

        if ((gradePointAvg >= 1.50) && ((totalCredits >= 0) && (totalCredits <= 29.5))) {
            System.out.println("You are in good standing.");
        } else if ((gradePointAvg >= 1.75) && ((totalCredits >= 30) && (totalCredits <= 59.5))) {
            System.out.println("You are in good standing.");
        } else if ((gradePointAvg >= 2) && (totalCredits >= 60)) {
            System.out.println("You are in good standing.");
        } else {
            System.out.println("You are not in good standing.");
        }

    }

}
