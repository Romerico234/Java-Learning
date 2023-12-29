import java.util.*;
import java.io.*;

public class Creature {
    private String name;
    private String description;
    private int endurance;
    private String fileName;
    private String[] phrase = new String[3];
    private int lastPhrase = 0;

    public Creature() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter name:");
        name = console.next();
        console.nextLine();
        System.out.println("Enter description:");
        description = console.nextLine();
        System.out.println("Enter endurance of creature:");
        endurance = console.nextInt();
        System.out.println("Enter file name:");
        fileName = console.next();
        console.nextLine();
        System.out.println("Enter three phrases the creature will say:");
        phrase[0] = console.nextLine();
        phrase[1] = console.nextLine();
        phrase[2] = console.nextLine();
    }

    public Creature(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        Scanner console = new Scanner(new File(fileName));
        this.name = console.nextLine();
        this.description = console.nextLine();
        this.endurance = console.nextInt();
        console.nextLine();
        this.phrase[0] = console.nextLine();
        this.phrase[1] = console.nextLine();
        this.phrase[2] = console.nextLine();
    }

    public void saveToFile() throws FileNotFoundException {
        File file = new File(fileName);
        PrintStream outputFile = new PrintStream(file);
        outputFile.printf("%s\n%s\n%d\n%s\n%s\n%s\n", name, description, endurance, phrase[0], phrase[1], phrase[2]);
    }

    public void saveToNewFile(String newFileName) throws FileNotFoundException {
        this.fileName = newFileName;
        saveToFile();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getEndurance() {
        return this.endurance;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        newDescription = this.description;
    }

    public void setEndurance(int newEndurance) {
        if (newEndurance < 0) {
            this.endurance = 0;
        } else {
            this.endurance = newEndurance;
        }

        if (this.endurance == 0) {
            System.out.println(this.name + " is tired.");
        }
    }

    public boolean isTired() {
        if (this.endurance <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public String printPhrase() {
        int index = (lastPhrase + 1) % phrase.length;
        if (index == lastPhrase) {
            index = 0;
        }
        lastPhrase = index;
        return phrase[index];
    }

    public void updatePhrase(String newPhrase) {
        int index = (lastPhrase + 1) % phrase.length;
        if (index == lastPhrase) {
            index = 0;
        }
        phrase[index] = newPhrase;
        lastPhrase = index;
    }

    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nEndurance: " + endurance +
                "\nPhrases: " + Arrays.toString(phrase);
    }

    public String reactToFood() {
        String reaction;
        if (this.endurance <= 20) {
            reaction = "The creature demolishes the food.";
        } else if ((this.endurance > 20) && (this.endurance < 50)) {
            reaction = "The creature checks out the food before eating it.";
        } else {
            reaction = "The creature ignores the food.";
        }
        return reaction;
    }

}
