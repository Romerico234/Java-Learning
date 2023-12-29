public class Sphere implements Shape3D {
    private double radius;

    public Sphere() { radius = 0; }
    
    public Sphere(double r) { radius = (r >= 0) ? r : 0; }
    
    public double getRadius() { return radius; }
    
    public double getArea() { return 4 * Math.PI * Math.pow(radius, 2); }
    
    public double getVolume() { return 4.0 * Math.PI * Math.pow(radius, 3) / 3.0; }
    
    public String toString() { return String.format("The radius of this sphere = %.2f.", radius); }
    
    public boolean equals(Object obj)  {
        if (obj instanceof Sphere){
            Sphere figure = (Sphere) obj;
            return radius == figure.radius;
        }    
        return false;
    }
}