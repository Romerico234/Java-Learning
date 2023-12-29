public abstract class Item {
    private int id;
    private String title;
    private int numOfCopies;

    public Item() {
        id = 0;
        title = "";
        numOfCopies = 0;
    }

    public Item(int someID, String someTitle, int amount) { set(someID, someTitle, amount); }

    public void set(int someID, String someTitle, int amount) {
        id = someID;
        title = someTitle;
        numOfCopies = amount < 0 ? 0 : amount;
    }

    public int getID() { return id; }

    public String getTitle() { return title; }

    public int getNumOfCopies() { return numOfCopies; }

    public boolean equals(Object obj) {
        if (obj instanceof Item) {
            Item item = (Item) obj;
            return id == item.id && title.equals(item.title); 
            //not including a comparision for number of copies (isn't a property of a single item)
        }
        return false;
    }

    public String toString() { return String.format("ID: %d\nTITLE: %s\nNUMBER OF COPIES: %d", id, title, numOfCopies); }

    public void print() { System.out.printf("ID: %d\nTITLE: %s\nNUMBER OF COPIES: %d", id, title, numOfCopies); }

    public void checkIn() { numOfCopies++; }

    public void checkOut() { numOfCopies = numOfCopies - 1 < 0 ? 0 : --numOfCopies; }

    public void addItem(int someID, String someTitle) {
        if(id == someID && title.equals(someTitle))
            numOfCopies++;
    }

}
