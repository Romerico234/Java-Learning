
//Client program for Person/Employee 
import java.util.Scanner;

public class ClientEmployee {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        Employee prof = new Employee("John", "Doe", 25.50, 50, "COSC");
        Employee newEmp = new Employee();

        System.out.print("Enter employee last name: ");
        String lastName = input.next();

        System.out.print("Enter employee first name: ");
        String firstName = input.next();

        System.out.print("Enter department: ");
        String dept = input.next();

        double payRate = getDouble(input, "Enter employee pay rate: ");

        int hours = getInt(input, "Enter employee hours worked: ");

        newEmp.setAll(firstName, lastName, payRate, hours, dept);

        System.out.println("--- Record for both employees with overriden .toString from subclass ---");
        System.out.println(prof);
        System.out.println(newEmp);

        System.out.println("---Output with calls to overriden method print from subclass ---");
        prof.print();
        newEmp.print();
      

        System.out.println("--- Output with calls to getters from the superclass ---");
        System.out.printf("The wages for %s %s from the %s department are $%5.2f.\n", prof.getFirstName(), prof.getLastName(), prof.getDepartment(), prof.calculatePay());
        System.out.printf("The wages for %s %s from the %s department are $%5.2f.\n", newEmp.getFirstName(), newEmp.getLastName(), newEmp.getDepartment(), newEmp.calculatePay());

        System.out.println("--- Call to overriden equals/subclass for 2 Employee objects ---");
        if (prof.equals(newEmp))
            System.out.println("Found an employee with same record");
        else
            System.out.println("Couldn't find an employee with same record.");
    }

    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next(); // Consume unwanted input type
            System.out.print("Not an Integer! Try again!\n");
            System.out.print(prompt);
        }
        return input.nextInt();
    }

    public static double getDouble(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextDouble()) {
            input.next(); // Consume unwanted input type
            System.out.print("Not a Double! Try again!\n");
            System.out.print(prompt);
        }
        return input.nextDouble();
    }
}