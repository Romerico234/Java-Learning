public abstract class MediaItem extends Item {
    private int runtime;

    public MediaItem(){
        super();
        runtime = 0;
    }

    public MediaItem(int id, String title, int amount, int otherRuntime) { set(id, title, amount, otherRuntime); }

    public void set(int id, String title, int amount, int otherRuntime) {
        super.set(id, title, amount);
        runtime = otherRuntime;
    }

    public int getRunTime() { return runtime; }

    public boolean equals(Object obj) {
        if (obj instanceof MediaItem) {
            MediaItem item = (MediaItem) obj;
            return super.equals(item) && runtime == item.runtime;
        }
        return false;
    }

    public String toString() { return super.toString() + String.format("\nRUNTIME: %d minutes", runtime); }

    public void print() {
        super.print();
        System.out.printf("\nRUNTIME: %d minutes", runtime);
    }

    public void addItem(int id, String title, int otherRuntime) {
        if (runtime == otherRuntime) 
            super.addItem(id, title);
    }
}
