public abstract class WrittenItem extends Item {
    private String author;

    public WrittenItem() {
        super();
        author = "";
    }

    public WrittenItem(int id, String title, int amount, String name) { set(id, title, amount, name); }

    public void set(int id, String title, int amount, String name) {
        super.set(id, title, amount);
        author = name;
    }

    public String getAuthor() { return author; }

    public boolean equals(Object obj) {
        if (obj instanceof WrittenItem) {
            WrittenItem item = (WrittenItem) obj;
            return super.equals(item) && author == item.author;
        }
        return false;
    }

    public String toString() { return super.toString() + String.format("\nAUTHOR: %s", author); }

    public void print() {
        super.print();
        System.out.printf("\nAUTHOR: %s", author);
    }

    public void addItem(int id, String title, String name) {
        if (author.equals(name))
            super.addItem(id, title);
    }
}