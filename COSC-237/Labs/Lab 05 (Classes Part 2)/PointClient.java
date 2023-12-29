import java.util.Scanner;

public class PointClient {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(7, 13);
        Point p3 = new Point(7, 15);
        Scanner in = new Scanner(System.in);

        System.out.println("---After declaration, constructors invoked--- Using toString()");
        System.out.println("First point is " + p1);
        System.out.println("First point is " + p2);
        System.out.println("First point is " + p3);

        if (p2.isVertical(p3))
            System.out.println(
                    "Second point " + p2 + " lines up vertically with third point " + p3);

        if (!p2.isHorizontal(p3))
            System.out.println("Second point " + p2 + " doesn't line up horizontally with third point "
                    + p3);

        int x1 = getInt(in, "Enter the x-coordinate for first point: ");
        int y1 = getInt(in, "Enter the y-coordinate for first point: ");

        p1.set(x1, y1);

        System.out.println("First point (after call to set) is " + p1);

        System.out.printf("Distance from origin for first point = %.2f\n", p1.distanceFromOrigin());
        System.out.printf("Distance from origin for second point = %.2f\n", p2.distanceFromOrigin());
        System.out.printf("Distance between first pint and second point = %.2f\n", p1.distance(p2));

        int a1 = 5;
        int b1 = 10;
        
        int a2 = 15;
        int b2 = 5;
        p1.translate(new Point(a1, b1));
        p2.translate(new Point(a2, b2));

        System.out.println("First point (after call to translate (" + a1 + ", " + b1 + ")) is " + p1);
        System.out.println("Second point (after call to translate (" + a2 + ", " + b2 + ")) is " + p2);

        if (!p1.equals(p2))
            System.out.println("---Call to equals: The 2 points are NOT equal.");
        
        System.out.println("---Calls to copy and print---");
        p1.copy(p2);

        System.out.print("First point (after call to copy) is ");
        p1.print();

        System.out.print("\nSecond point (after call to copy) is ");
        p2.print();

        if (p1.equals(p2))
            System.out.println("\n---Call to equals after call to copy: The 2 points are equal.");
        
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
