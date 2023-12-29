import java.util.*;

public class TimeDLLClient {
    public static final int TIME_MAX_SIZE = 10;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        DoubleLinkedList<Time> list1 = new DoubleLinkedList<Time>();

        Time[] time = new Time[TIME_MAX_SIZE];
        for (int i = 0; i < TIME_MAX_SIZE; i++) {
            time[i] = new Time();
            time[i].setTime(i + 1, i + i, i * i);
            list1.insertNode(time[i]);
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
                    DoubleLinkedList<Time> compareList = new DoubleLinkedList<Time>();
                    Time[] time2 = new Time[TIME_MAX_SIZE];
                    for (int i = 0; i < TIME_MAX_SIZE; i++) {
                        time2[i] = new Time();
                        time2[i].setTime(i + 1, i + i, i * i);
                        compareList.insertNode(time2[i]);
                    }
                    System.out.println("Generated a new a list for equality: " + compareList);
                    if (compareList.equals(list1))
                        System.out.println("The 2 lists are equals");
                    else
                        System.out.println("The 2 lists are NOT equals");
                    break;

                case 6:
                case 7:
                    DoubleLinkedList<Time> copy = new DoubleLinkedList<Time>();
                    if (choice == 6)
                        copy.copy(list1);
                    else if (choice == 7)
                        copy.reversedCopy(list1);
                    System.out.println("The copied list is: ");
                    copy.print();
                    System.out.println();
                    System.out.println("The copied list reversed is: ");
                    copy.reversePrint();
                    System.out.println();
                    break;

                case 8:
                case 9:
                    int hrs = getInt(in, "Enter time (h m s): ");
                    int mins = getInt(in, "");
                    int secs = getInt(in, "");
                    while (hrs < 0 || mins < 0 || secs < 0) {
                        System.out.println("Hours, minutes, seconds must be positive!");
                        hrs = getInt(in, "Enter time (h m s): ");
                        mins = getInt(in, "");
                        secs = getInt(in, "");
                    }
                    Time searchItem = new Time(hrs, mins, secs);
                    if (choice == 8) {
                        if (list1.search(searchItem))
                            System.out.println("Found item!");
                        else
                            System.out.println("Item was not found.");
                    } else if (choice == 9) {
                        DoubleLinkedList<Time> list2 = new DoubleLinkedList<Time>();
                        System.out.println("Will copy into second list. List one destroyed.");
                        while (!list1.isEmptyList()) {
                            Time item = list1.front();
                            list1.deleteNode(item);
                            if (!item.equals(searchItem))
                                list2.insertNode(item);
                        }
                        System.out.println("Second list (sorted): " + list2);
                        System.out.println("First list should be empty.");
                        list1.print();
                        System.out.println();
                    }
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
        System.out.println("\t9) Remove every instance of some time in the list (causes data loss, will quit)");
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
