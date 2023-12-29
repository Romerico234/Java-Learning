public class CircularCone extends CircularShapeWithHeight {
    public CircularCone() { super(); }

    public CircularCone(double radius, double height) { super(radius, height); }

    public double getArea() {
        double r = getRadius();
        double h = getHeight();
        return Math.PI * r * Math.sqrt(r * r + h * h);
    }

    public double getVolume() { return getCrossSectionArea() * getHeight() / 3.0; }

    public String toString() { return String.format("For this circular cone, the radius = %.2f and the height = %.2f.", getRadius(), getHeight());  }

    public boolean equals(Object obj) {
        if (obj instanceof CircularCone){
            CircularCone figure = (CircularCone) obj;
            return getRadius() == figure.getRadius() && getHeight() == figure.getHeight();
        }
        return false;
    }
}