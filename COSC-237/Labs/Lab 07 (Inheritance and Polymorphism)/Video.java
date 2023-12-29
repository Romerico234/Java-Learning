public class Video extends MediaItem {
    private String director;
    private String genre;
    private int yearPublished;

    public Video() {
        super();
        director = "";
        genre = "";
        yearPublished = 0;
    }

    public Video(int id, String title, int amount, int runtime, String someDirector, String someGenre, int year) {
        set(id, title, amount, runtime, someDirector, someGenre, year);
    }

    public void set(int id, String title, int amount, int runtime, String someDirector, String someGenre, int year) {
        super.set(id, title, amount, runtime);
        director = someDirector;
        genre = someGenre;
        yearPublished = year;
    }

    public String getDirector() { return director; }

    public String getGenre() { return genre; }

    public int getYearPublished() { return yearPublished; }

    public boolean equals(Object obj) {
        if (obj instanceof Video) {
            Video video = (Video) obj;
            return super.equals(video) && director.equals(video.director) && genre.equals(video.genre) && yearPublished == video.yearPublished;
        }
        return false;
    }
    
    public String toString() {
        return super.toString() + String.format("\nDIRECTOR: %s\nGENRE: %s\nYEAR RELEASED: %d", director, genre, yearPublished);
    }

    public void print() {
        super.print();
        System.out.printf("\nDIRECTOR: %s\nGENRE: %s\nYEAR RELEASED: %d", director, genre, yearPublished);
    }

    public void addItem(int id, String title, int runtime, String someDirector, String someGenre, int year) {
        if (director.equals(someDirector) && genre.equals(someGenre) && yearPublished == year) 
            super.addItem(id, title, runtime);
    }

    
}
