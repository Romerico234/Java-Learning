//Interface: LinkedListIntADT 
public interface LinkedListIntADT {
    public boolean isEmptyList();         //Method to determine whether the list is empty. 
    public void initializeList();         //Method to initialize the list to an empty state.
    public void print();                  //Method to output the data contained in each node.
    public int length();                  //Method to return the number of nodes in the list.
    public int front();                     //Method to return a reference to the first node 
    public int back();                      //Method to return a reference to the first node 
    public boolean search(int searchItem);  //Method to determine whether searchItem is in the list.
    public void insertFirst(int newItem);   //Method to insert newItem in the list.
    public void insertLast(int newItem);    //Method to insert newItem at the end of the list.
    public void deleteNode(int deleteItem); //Method to delete deleteItem from the list.
}
