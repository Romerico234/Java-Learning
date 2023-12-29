public class Point {
    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int num1, int num2) {
        x = (num1 < 0) ? 0 : num1;
        
        y = (num2 < 0) ? 0 : num2;
    }

    public void set(int num1, int num2) {
        x = (num1 < 0) ? 0 : num1;
        y = (num2 < 0) ? 0 : num2;
    }

    public void print(){
        System.out.print("(" + x + ", " + y + ")");
    }


    public String toString(){
        return "(" + x + ", " + y + ")"; 
    }

    public boolean equals(Object o){
        if (o instanceof Point){
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        return false;
    }

    public void copy(Point p){
        x = p.x;
        y = p.y;
    }

    public Point getCopy(Point p){
        return new Point(x, y);
    }

    public double distanceFromOrigin(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public double distance(Point p){
        return Math.sqrt(Math.pow(p.x-x,2) + Math.pow(p.y-y,2));
    }

    public void translate(Point p){
        x += p.x;
        y += p.y;
    }

    public boolean isHorizontal(Point p){
        return y == p.y;
    }

    public boolean isVertical(Point p){
        return x == p.x;
    }

    public double slope(Point p){
        return (double)((p.y-y)/(p.x-x));
    }


}