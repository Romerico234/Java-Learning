public abstract class CircularShapeWithHeight extends CircularShape {
    private double height;

    public CircularShapeWithHeight() { 
        super(); 
        height = 0; 
    }

    public CircularShapeWithHeight(double r, double h) { 
        super(r);
        height = (h >= 0) ? h : 0;
    }

    public double getHeight() { return height; }
}