import java.io.*;
import java.util.*;

public class ClientCode {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console;
        console = new Scanner(System.in);
        String newFile = "New File";
        Creature creature = new Creature();
        System.out.println("Name: " + creature.getName());
        System.out.println("Description: " + creature.getDescription());
        System.out.println("Endurance: " + creature.getEndurance());
        System.out.println("Phrase 1: " + creature.printPhrase());
        System.out.println("Phrase 2: " + creature.printPhrase());
        System.out.println("Phrase 3: " + creature.printPhrase());
        System.out.println("Provide three new phrases for the creature: ");
        creature.updatePhrase(console.nextLine());
        creature.updatePhrase(console.nextLine());
        creature.updatePhrase(console.nextLine());
        System.out.println("Phrase 1: " + creature.printPhrase());
        System.out.println("Phrase 2: " + creature.printPhrase());
        System.out.println("Phrase 3: " + creature.printPhrase());
        System.out.println("Phrase 4: " + creature.printPhrase());
        while (creature.isTired()) {
            creature.setEndurance(creature.getEndurance() - 1);
        }
        creature.setEndurance(20);
        System.out.println(creature.reactToFood());
        System.out.println("Enter new name for creature: ");
        creature.setName(console.next());
        creature.saveToNewFile("creature.dat");
        Creature newCreature = new Creature("creature.dat");
        System.out.println(newCreature.toString());

    }
}
