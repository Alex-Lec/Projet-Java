package mural;

public class Circle extends Ellipsis {
    private double radius;

    public Circle(Point middle, double radius) {
        super(middle, radius, radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void updateRadius() {
        this.radius = super.getHalfMajorAxis();
    }

    @Override
    public void homothety(Point p, double ratio) {
        super.homothety(p, ratio);
        updateRadius();
    }

    @Override
    public void translation(double[][] matrix) {
        super.translation(matrix);
    }

    @Override
    public void rotation(Point p, int angle) {
        super.rotation(p, angle);
    }

    @Override
    public void centralSymmetry(Point p) {
        super.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(Line l) {
        super.axialSymmetry(l);
    }
}
