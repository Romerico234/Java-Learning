public class CD extends MediaItem {
    private String artist;
    private String genre;

    public CD() {
        super();
        artist = "";
        genre = "";
    }

    public CD(int id, String title, int amount, int runtime, String someArtist, String someGenre) {
        set(id, title, amount, runtime, someArtist, someGenre);
    }

    public void set(int id, String title, int amount, int runtime, String someArtist, String someGenre) {
        super.set(id, title, amount, runtime);
        artist = someArtist;
        genre = someGenre;
    }

    public String getArtist() { return artist; }

    public String getGenre() { return genre; }

    public boolean equals(Object obj) {
        if (obj instanceof CD) {
            CD cd = (CD) obj;
            return super.equals(cd) && artist.equals(cd.artist) && genre.equals(cd.genre);
        }
        return false;
    }
    
    public String toString() { return super.toString() + String.format("\nARTIST: %s\nGENRE: %s", artist, genre); }

    public void print() {
        super.print();
        System.out.printf("\nARTIST: %s\nGENRE: %s", artist, genre);
    }

    public void addItem(int id, String title, int runtime, String someArtist, String someGenre) {
        if (artist.equals(someArtist) && genre.equals(someGenre)) 
            super.addItem(id, title, runtime);
    }
}
