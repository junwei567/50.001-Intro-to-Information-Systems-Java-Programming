package q1;
// starting code

public class Circle {
    private double x;
    private double y;
    private double radius;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    public boolean contains(double px, double py) {
        double dist = Math.sqrt(Math.pow(px-this.x,2) + Math.pow(py-this.y,2));
        if (dist > this.radius) return false;
        else return true;
    }

    public boolean contains(Circle c) {
        double dist = Math.sqrt(Math.pow(c.x-this.x,2) + Math.pow(c.y-this.y,2));
        double yy = c.radius * c.y / dist;
        double xx = c.radius * c.x / dist;
        if (c.contains(xx, yy)) return true;
        else return false;
    }

    public boolean overlaps(Circle c) {
        double dist = Math.sqrt(Math.pow(c.x-this.x,2) + Math.pow(c.y-this.y,2));
        double xx = (dist - c.radius) / dist * (c.x - x);
        double yy = (dist - c.radius) / dist * (c.y - y);
        if (!contains(c.x, c.y) && contains(xx, yy)) return true;
        else return false;
    }
}
