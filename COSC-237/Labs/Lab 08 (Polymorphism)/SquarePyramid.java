public class SquarePyramid implements Shape3D {
    private double length;
    private double height;

    public SquarePyramid() {
        length = 0;
        height = 0;
    }

    public SquarePyramid(double l, double h) { 
        length = (l >= 0) ? l : 0;
        height = (h >= 0) ? h : 0;
    }

    public double getLength() { return length; }

    public double getHeight() { return height; }

    public double getArea() { return length * (length + Math.sqrt(length * length + 4 * height * height)); }

    public double getVolume() { return length * length * height / 3.0; }

    public String toString() { return String.format("For this square pyramid, the base has length = %.2f and height = %.2f.", length, height); }

    public boolean equals(Object obj) { 
        if (obj instanceof SquarePyramid){
            SquarePyramid figure = (SquarePyramid) obj;
            return length == figure.length && height == figure.height;
        }    
        return false;
    }

}