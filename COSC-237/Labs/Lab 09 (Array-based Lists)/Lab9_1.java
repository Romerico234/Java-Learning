//Testing the method scaleByK added to the user created UnorderedArrayList class 
public class Lab9_1 {
    public static final int SIZE = 200;
    public static void main(String[] args)  {
        UnorderedArrayList list = new UnorderedArrayList(SIZE); 
        list.insertEnd(2);
        list.insertEnd(4); 
        list.insertEnd(-2); 
        list.insertEnd(5); 
        list.insertEnd(3); 
        list.insertEnd(0);
        list.insertEnd(7);
        System.out.println("The original list is: "); 
        list.print(); 
        System.out.println("The list after method call(class) is: "); 
        list.scaleByK();
        list.print(); 
	}
}
/*OUTPUT:
The original list is: 
-10  5  3  4  0  7  
The list after method call is: 
5  5  5  5  5  3  3  3  4  4  4  4  7  7  7  7  7  7  7  
*/