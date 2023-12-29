import java.util.Scanner;

public class TimeClient {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        Time t1 = new Time(8, 15, 30);
        Time t2 = new Time();


        System.out.println("Initial time t1 (alternate constructor invoked) - military format: "+ t1.toMilitary());
        System.out.println("Initial time t1 (alternate constructor invoked) - military format: "+ t1.toStandard());
        System.out.println("Initial time t2 (default constructor invoked) - military format: "+ t2.toMilitary());
        System.out.println("Initial time t2 (default constructor invoked) - standard format: "+ t2.toStandard());

        t2.setTime(9, 45, 35);
        System.out.println("t2 after call to setTime - military format: "+t2.toMilitary());
        System.out.println("t2 after call to setTime - standard format: "+t2.toStandard());

        if (t1.equals(t2))
            System.out.println("After call to equals: times are equal");
        else
            System.out.println("After call to equals: times are not equal");
        
        if (t1.lessThan(t2))
            System.out.println("After call to lessThan: t1 is less than t2");
        else   
            System.out.println("After call to lessThan: t1 is not less than t2");

        if (t2.greaterThan(t1))
            System.out.println("After call to greaterThan: t2 is greater than t1");
        else
            System.out.println("After call to greaterThan: t2 is not greater than t1");

        int h = getInt(in, "Enter hours: ");
        int m = getInt(in, "Enter minutes: ");
        int s = getInt(in, "Enter seconds: ");

        t1.setTime(h, m, s);

        System.out.println("New time t1 after call to setTime - standard format: " + t1.toStandard());

        t1.advanceSecs();
        System.out.println("New time t1 after call to advanceSecs - standard format: " + t1.toStandard());
    

        t2.copy(t1);
        System.out.println("Test toString for t2: "+t2.toString());  
        
        if (t2.greaterOrEquals(t1))
            System.out.println("t2 is greater than or equal to t1");
        else
            System.out.println("t2 is less than t1");

        Time t3 = t1.getCopy();

        if (t3.lessOrEquals(t2))
            System.out.println("t3 is less than or equal to t2");
        else
            System.out.println("t3 is greater than t2");

        t3.advanceSecs();
        t3.printStandard();


        t3.advanceMins();
        t3.printStandard();

        t3.advanceHrs();
        t3.printStandard();


        t3.printMilitary();
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
}
