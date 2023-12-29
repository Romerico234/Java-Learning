import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Book mockingBird = new Book(123456, "To Kill a Mocking Bird", 5, "Harper Lee");
        JournalPaper paper = new JournalPaper(2243, "Why college should be free", 1, "Richard Ricky", 2020);
        Video godFather = new Video(1111, "The GodFather", 3, 215, "Francis Ford Coppola", "drama", 1981);
        CD thriller = new CD(010230, "Thriller", 10, 43, "Michael Jackson", "pop");
        int choice = menu();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.println(mockingBird + "\n");
                    mockingBird.checkOut();
                    System.out.println("After the book was checked-out, the number of copies changed. The new info is: ");
                    mockingBird.print();
                    System.out.println();
                    break;
                case 2:
                    System.out.println(paper + "\n");
                    paper.addItem(2243, "Why college should be free", "Richard Ricky", 2020);
                    System.out.println("After a new copy of this paper was added, the number of copies changed. The new info is: ");
                    paper.print();
                    System.out.println();
                    break;
                case 3:
                    System.out.println(godFather + "\n");
                    godFather.checkIn();
                    System.out.println("After the video was checked-in, the number of copies changed. The new info is: ");
                    godFather.print();
                    System.out.println();
                    break;
                case 4:
                    System.out.println(thriller + "\n");
                    System.out.println("Enter new CD for comparision");

                    int id = getPositiveInt(input, "ID: ");
                    input.nextLine();

                    System.out.print("Title: ");
                    String title = input.nextLine();

                    int amount = getPositiveInt(input, "Amount: ");
                    int runtime = getPositiveInt(input, "Runtime: ");
                    input.nextLine();;

                    System.out.print("Artist: ");
                    String artist = input.nextLine();

                    System.out.print("Genre: ");
                    String genre = input.nextLine();

                    CD otherCD = new CD(id, title, amount, runtime, artist, genre);

                    if (thriller.equals(otherCD))
                        System.out.println("Same CDs!");
                    else
                        System.out.println("Different CDs.");

                    break;
                default:
                    System.out.println("Invalid range! Try again!");
                    break;
            }

            choice = menu();
        }
        System.out.println("Thanks! Goodbye.");
    }

    public static int menu() {
        System.out.println("Your options are:");
        System.out.println("-----------------");
        System.out.println("\t1) Display info about a Book");
        System.out.println("\t2) Display info about a Journal Paper");
        System.out.println("\t3) Display info about a Video");
        System.out.println("\t4) Display info about a CD");

        return getInt(new Scanner(System.in), "Please enter your option: ");
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

    public static int getPositiveInt(Scanner input, String prompt) {
        int pos = getInt(input, prompt);
        while (pos < 0) {
            System.out.println("Must be positive, REENTER");
            pos = getInt(input, prompt);
        }
        return pos;
    }

}