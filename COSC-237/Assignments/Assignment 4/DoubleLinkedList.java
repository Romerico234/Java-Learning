public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
    // Double linked list node class
    public class DoubleLinkedListNode<T> {
        T info;
        DoubleLinkedListNode<T> next;
        DoubleLinkedListNode<T> back;

        public DoubleLinkedListNode() {
            info = null;
            next = null;
            back = null;
        }

        public String toString() {
            return info.toString();
        }
    }

    protected int count; // number of nodes
    protected DoubleLinkedListNode<T> first; // reference to first node
    protected DoubleLinkedListNode<T> last; // reference to last node

    public void insertNode(T insertItem) {
        boolean found;
        DoubleLinkedListNode<T> current;// moving reference
        DoubleLinkedListNode<T> trailCurrent = null; // just before current
        // Set up node to be inserted
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
        newNode.info = insertItem;
        newNode.next = null;
        newNode.back = null;
        // if the list is empty, newNode is the only node
        if (first == null) {
            first = newNode;
            last = newNode;
            count++;
        } else {
            found = false;
            current = first;
            // search the list
            while (current != null && !found) {
                Comparable<T> temp = (Comparable<T>) current.info;
                if (temp.compareTo(insertItem) >= 0)
                    found = true;
                else {
                    trailCurrent = current;
                    current = current.next;
                }
            }
            // insert new node before first
            if (current == first) {
                first.back = newNode;
                newNode.next = first;
                first = newNode;
                count++;
            } else {
                // insert newNode between trailCurrent and current
                if (current != null) {
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    newNode.next = current;
                    current.back = newNode;
                } else {
                    // insert new node after last
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    last = newNode;
                }
                count++;
            }
        }
    }

    public void deleteNode(T deleteItem) {
        DoubleLinkedListNode<T> current; // moving reference
        DoubleLinkedListNode<T> trailCurrent;// just before current
        boolean found;
        if (first == null)
            System.err.println("Cannot delete from an empty list.");
        // if node to be deleted is the first node
        else if (first.info.equals(deleteItem)) {
            current = first;
            first = first.next;
            if (first != null)
                first.back = null;
            else
                last = null;
            count--;
        } else {
            found = false;
            current = first;
            // search the list
            while (current != null && !found) {
                Comparable<T> temp = (Comparable<T>) current.info;
                if (temp.compareTo(deleteItem) >= 0)
                    found = true;
                else
                    current = current.next;
            }
            if (current == null)
                System.out.println("The item to be deleted is not in the list.");
            else if (current.info.equals(deleteItem)) {
                trailCurrent = current.back;
                trailCurrent.next = current.next;
                if (current.next != null)
                    current.next.back = trailCurrent;
                if (current == last)
                    last = trailCurrent;
                count--;
            } else
                System.out.println("The item to be deleted is not in list.");
        }
    }

    public void initializeList() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmptyList() {
        return first == null;
    }

    public T front() {
        return first.info;
    }

    public T back() {
        return last.info;
    }

    public int length() {
        return count;
    }

    public void print() {
        DoubleLinkedListNode<T> current;
        current = first;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
    }

    public void reversePrint() {
        DoubleLinkedListNode<T> current;
        current = last;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.back;
        }
    }

    public boolean search(T searchItem) {
        DoubleLinkedListNode<T> current = first;
        boolean found = false;
        while (current != null && !found) {
            Comparable<T> temp = (Comparable<T>) current.info;
            if (temp.compareTo(searchItem) >= 0)
                found = true;
            else
                current = current.next;
        }
        if (found)
            found = current.info.equals(searchItem);
        return found;
    }

    public String toString() {
        if (first == null)
            return "EMPTY";
        DoubleLinkedListNode<T> current;
        String result = "[head] - " + first.info + " - ";
        current = first.next;
        while (current != null) {
            result += current.info + " - ";
            current = current.next;
        }
        result += "[tail]";
        return result;
    }

    public String recursiveToString() {
        if (first == null)
            return "EMPTY";
        return "[head]" + recursiveToString(first);
    }

    private String recursiveToString(DoubleLinkedListNode<T> current) { // helper method
        if (current == null)
            return " - [tail]";
        else
            return " - " + current.info + recursiveToString(current.next);
    }

    public String backwardsString() {
        if (first == null)
            return "EMPTY";
        String result = "[tail] - " + last.info + " - ";
        DoubleLinkedListNode<T> current;
        current = last.back;
        while (current != null) {
            result += current.info + " - ";
            current = current.back;
        }
        result += "[head]";
        return result;
    }

    public String recursiveBackwardsString() {
        if (first == null)
            return "EMPTY";
        return "[tail]" + recursiveBackwardsString(last);
    }

    private String recursiveBackwardsString(DoubleLinkedListNode<T> current) { // helper method
        if (current == null)
            return " - [head]";
        else
            return " - " + current.info + recursiveBackwardsString(current.back);
    }

    public boolean equals(Object o) {
        DoubleLinkedList<T> list = (DoubleLinkedList<T>) o;
        if (list.count != count)
            return false;
        DoubleLinkedListNode<T> current1 = first;
        DoubleLinkedListNode<T> current2 = list.first;
        while (current1 != null) {
            if (!current1.info.equals(current2.info))
                return false;
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public void copy(DoubleLinkedList<T> otherList) {
        initializeList(); //initiliaze list (works if the otherList is empty)
        DoubleLinkedListNode<T> current = otherList.first;
        while (current != null) {
            insertNode(current.info);
            current = current.next;
        }
    }

    public void reversedCopy(DoubleLinkedList<T> otherList) {
        if (otherList.first == null)
            initializeList();
        else {
            DoubleLinkedListNode<T> current = first;
            DoubleLinkedListNode<T> currentOther = otherList.last;
            while (currentOther != null) {
                if (current != null){
                    current.info = currentOther.info;
                    current = current.next;
                } else { // If the current list is shorter, insert a new node at the end
                    DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
                    newNode.info = currentOther.info;
                    if (first == null) {
                        first = newNode;
                        last = newNode;
                    } else {
                        last.next = newNode;
                        newNode.back = last;
                        last = newNode;
                    }
                    count++;
                }   
                currentOther = currentOther.back;
            }
            while (current != null) { // If the current list is longer, remove the extra nodes
                DoubleLinkedListNode<T> temp = current.next;
                current.next = null;
                current.back = null;
                current = temp;
                count--;
            }
        }
    }
}