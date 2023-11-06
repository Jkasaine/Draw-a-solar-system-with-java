public class Ring {
    private Point center;
    private double innerRadius;
    private double outerRadius;

    public Ring(Point center, double innerRadius, double outerRadius) {
        this.center = center;
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    public Point getCenter() {
        return center;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public double getOuterRadius() {
        return outerRadius;
    }

    public boolean contains(Point point) {
        double distance = center.distanceTo(point);
        return distance >= innerRadius && distance <= outerRadius;
    }
}
