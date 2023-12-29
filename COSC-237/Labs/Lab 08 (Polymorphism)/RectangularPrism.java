public class RectangularPrism implements Shape3D {
    private double length;
    private double width;
    private double height;

    public RectangularPrism() { 
        length = 0;
        width = 0;
        height = 0;
    }

    public RectangularPrism(double l, double w, double h) { 
        length = (l >= 0) ? l : 0;
        width = (w >= 0) ? w : 0;
        height = (h >= 0) ? h : 0;
    }

    public double getLength() { return length; }

    public double getWidth() { return width; }
    
    public double getHeight() { return height; }
    
    public double getArea() { return 2 * (length * width + width * height + length * height); }
    
    public double getVolume() { return length * width * height; }
    
    public String toString() { return String.format("For this rectangular prism, the base has length = %.2f, width = %.2f, and height = %.2f.", length, width, height); }
    
    public boolean equals(Object obj)  {
        if (obj instanceof RectangularPrism){
            RectangularPrism figure = (RectangularPrism) obj;
            return length == figure.length && width == figure.width && height == figure.height;
        }    
        return false;
    }
}