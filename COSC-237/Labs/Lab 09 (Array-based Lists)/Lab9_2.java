
//Testing the method scaleByK using the Java ArrayList class 
import java.util.ArrayList;

public class Lab9_2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(-2);
        list.add(5);
        list.add(3);
        list.add(0);
        list.add(7);
        System.out.println("The original list is: ");
        print(list);
        System.out.println("The list after method call is: ");
        scaleByK(list);
        print(list);
    }

    // Problem 1.2
    public static void scaleByK(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) > 0) {
                for (int j = 0; j < list.get(i); j++)
                    list.add(list.get(i));
            }
        }
        for (int i = 0; i < size; i++)
            list.remove(0);
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
 * 2 4 -2 5 3 0 7
 * The list after method call is:
 * 2 2 4 4 4 4 5 5 5 5 5 3 3 3 7 7 7 7 7 7 7
 */