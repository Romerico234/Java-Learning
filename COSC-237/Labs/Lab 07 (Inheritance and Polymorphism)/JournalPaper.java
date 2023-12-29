public class JournalPaper extends WrittenItem {
    private int yearPublished;

    public JournalPaper() {
        super();
        yearPublished = 0;
    }

    public JournalPaper(int id, String title, int amount, String name, int year) { set(id, title, amount, name, year); }

    public void set(int id, String title, int amount, String name, int year) {
        super.set(id, title, amount, name);
        yearPublished = year;
    }

    public int getYear() { return yearPublished; }

    public boolean equals(Object obj) {
        if (obj instanceof JournalPaper) {
            JournalPaper paper = (JournalPaper) obj;
            return super.equals(paper) && yearPublished == paper.yearPublished;
        }
        return false;
    }

    public String toString() { return super.toString() + String.format("\nYEAR RELEASED: %d", yearPublished); }

    public void print() {
        super.print();
        System.out.printf("\nYEAR RELEASED: %d", yearPublished);
    }

    public void addItem(int id, String title, String name, int year) {
        if (yearPublished == year)
            super.addItem(id, title, name);
    }

}
