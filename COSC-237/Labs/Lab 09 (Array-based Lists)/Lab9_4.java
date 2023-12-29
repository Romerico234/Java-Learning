
//Testing the method removeDuplicates using the Java ArrayList class 
import java.util.ArrayList;

public class Lab9_4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // list.add(2);
        // list.add(2);
        // list.add(2);
        // list.add(5);
        // list.add(5);
        // list.add(8);
        // list.add(9);
        // list.add(9);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println("The original list is: ");
        print(list);
        System.out.println("The list after method call is: ");
        removeDuplicates(list);
        print(list);
    }

    //Problem 2.2
    public static void removeDuplicates(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i) == list.get(j)){
                    list.remove(i);
                    i--;
                }
            }
        }
    }

    public static void print(ArrayList<Integer> someList) {
        for (Integer i : someList)
            System.out.print(i + "  ");
        System.out.println();
    }
}
/*
 * OUTPUT:
 * The original list is:
 * 2 2 2 5 5 8 9 9
 * The list after method call is:
 * 2 5 8 9
 */