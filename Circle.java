public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public boolean contains(Point point) {
        double distance = center.distanceTo(point);
        return distance <= radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
