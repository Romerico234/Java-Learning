//Class: UnorderedLinkedListInt extends 
//Class: LinkedListClass
public class UnorderedLinkedListInt extends LinkedListIntClass {
    //Default constructor
    public UnorderedLinkedListInt() {
        super();
    }

    public boolean search(int searchItem)  {
        LinkedListNode current; //variable to traverse the list
        current = first;  
        while (current != null) 
            if (current.info == searchItem) 
                return true;
            else
               current = current.link; 
        return false;
    }

    public void insertFirst(int newItem) {
        LinkedListNode newNode;  //variable to create the new node
        //create and insert newNode before first
        newNode = new LinkedListNode(newItem, first); 
        first = newNode;   
        if (last == null)   
            last = newNode;
        count++;     
    }

    public void insertLast(int newItem)  {
        LinkedListNode newNode; //variable to create the new node
        //create newNode
        newNode = new LinkedListNode(newItem, null);  
        if (first == null) {
            first = newNode;
            last = newNode;
        }
        else {
            last.link = newNode; 
            last = newNode;      
                                 
        }
        count++;
    }

    public void deleteNode(int deleteItem) {
        LinkedListNode current; //variable to traverse the list
        LinkedListNode trailCurrent; //variable just before current
        boolean found;
        //Case 1; the list is empty
        if ( first == null)    
            System.err.println("Cannot delete from an empty list.");
        else {
            //Case 2: the node to be deleted is first
            if (first.info == deleteItem) {
                first = first.link;
                if (first == null)  //the list had only one node
                    last = null;
                count--;
            }
            else {  //search the list for the given info
                found = false;
                trailCurrent = first; //trailCurrent points to first node
                current = first.link; //current points to second node
                while (current != null && !found) {
                    if (current.info == deleteItem)
                        found = true;
                    else {
                        trailCurrent = current;
                        current = current.link;
                    }
                }
                //Case 3; if found, delete the node
                if (found) {
                    count--;
                    trailCurrent.link = current.link;
                    if (last == current)  //node to be deleted was the last node
                       last = trailCurrent;  
                }
                else
                   System.out.println("Item to be deleted is not in the list.");
            }
        }
    }
    
    // New Methods - your job:

    //added method sum for a list of int
    public int findSum()  {
        int sum = 0;
        LinkedListNode current = new LinkedListNode();
        current = first;
        while (current != null) {
            sum += current.info;
            current = current.link;
        }
        return sum;
    }
    
    //added method min for a list of int
    public int findMin()  {
        int min = first.info;
        LinkedListNode current = new LinkedListNode();
        current = first.link;
        while (current != null) {
            if (current.info < min)
                min = current.info;
            current = current.link;
        }
        return min;
        
    }

    // creates a comma-separated, bracketed version of the list
    public String toString() {
        if (first == null) {
            return "[]";
        }
    
        String list = "[" + first.info;
        LinkedListNode current = first.link;
    
        while (current != null) {
            list = list + "," + current.info;
            current = current.link;
        }
    
        list = list + "]";
        return list;
    }
    
}