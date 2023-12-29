public class Cylinder extends CircularShapeWithHeight {
    public Cylinder() { super(); }

    public Cylinder(double radius, double height) { super(radius, height); }

    public double getArea() { return getCrossSectionPerimeter() * getHeight() + 2 * getCrossSectionArea(); }

    public double getVolume() { return getCrossSectionArea() * getHeight(); }

    public String toString() { return String.format("For this cylinder, the radius = %.2f and height = %.2f.", getRadius(), getHeight()); };

    public boolean equals(Object obj) {
        if (obj instanceof Cylinder){
            Cylinder figure = (Cylinder) obj;
            return getRadius() == figure.getRadius() && getHeight() == figure.getHeight();
        }
        return false;
    }
}