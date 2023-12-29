import java.util.*;

public class StringDLLClient {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        DoubleLinkedList<String> list1 = new DoubleLinkedList<String>();

        System.out.println("Enter first name(s), \"quit\" to end: ");
        String name = in.next();
        while (!name.equals("quit")) {
            list1.insertNode(name);
            name = in.next();
        }

        int choice = menu();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.println("(Testing toString) First list sorted is: " + list1);
                    break;
                case 2:
                    System.out.println("(Testing recursive toString) First list sorted is: "
                            + list1.recursiveToString());
                    break;
                case 3:
                    System.out.println("(Testing backwardsString) First list reversed is: " +
                            list1.backwardsString());
                    break;
                case 4:
                    System.out.print("(Testing recursive backwardsString) First list reversed is: " +
                            list1.recursiveBackwardsString());
                    break;

                case 5:
                    DoubleLinkedList<String> compareList = new DoubleLinkedList<String>();
                    System.out.println("Enter first name(s) for new list, \"quit\" to end: ");
                    name = in.next();
                    while (!name.equals("quit")) {
                        compareList.insertNode(name);
                        name = in.next();
                    }
                    if (compareList.equals(list1))
                        System.out.println("The 2 lists are equals");
                    else
                        System.out.println("The 2 lists are NOT equals");
                    break;

                case 6:
                case 7:
                    DoubleLinkedList<String> resultCopy = new DoubleLinkedList<String>();
                    if (choice == 6) {
                        resultCopy.copy(list1);
                        System.out.println("The copied list is: ");
                    } else if (choice == 7) {
                        resultCopy.reversedCopy(list1);
                        System.out.println("The reversed copied list is: ");
                    }

                    resultCopy.print();
                    System.out.println();

                    System.out.println("This list reversed is: ");
                    resultCopy.reversePrint();
                    System.out.println();
                    break;

                case 8:
                    System.out.println("Search for a name in the list: ");
                    String searchItem = in.next();
                    if (list1.search(searchItem))
                        System.out.println("Found item!");
                    else
                        System.out.println("Item was not found.");
                    break;

                case 9:
                    DoubleLinkedList<String> list2 = new DoubleLinkedList<String>();
                    System.out.println("Enter letter: ");
                    char letter = Character.toUpperCase(in.next().charAt(0));
                    System.out.println(
                            "Will copy in second list only names that don't start with " + letter
                                    + ". List one destroyed.");
                    while (!list1.isEmptyList()) {
                        String item = list1.front();
                        list1.deleteNode(item);
                        if (item.charAt(0) != letter)
                            list2.insertNode(item);
                    }
                    System.out.println(
                            "Second list should hold names that don't start with " + letter + " (sorted): " + list2);
                    System.out.println("First list should be empty.");
                    list1.print();
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid range! Try again!");
                    break;
            }
            if (choice == 9) //ending when 9 is chosen since list1 becomes empty
                choice = 0;
            else
                choice = menu();
        }
        System.out.println("Testing completed.");
    }

    public static int menu() {
        System.out.println("Your options are:");
        System.out.println("-----------------");
        System.out.println("\t1) Test toString");
        System.out.println("\t2) Test recursive toString");
        System.out.println("\t3) Test backwardsString");
        System.out.println("\t4) Test recursive backwardsString");
        System.out.println("\t5) Test equals");
        System.out.println("\t6) Make a copy");
        System.out.println("\t7) Make a reversed copy");
        System.out.println("\t8) Search for item");
        System.out.println("\t9) Remove every instance of some first letter in the list of names (causes data loss, will quit)");
        System.out.println("\t0) EXIT");
        return getInt(in, "Please enter your option: ");
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
}
