package mural;

public class Line extends Shape {
    private int thickness;
    private double length;

    public Line(Point p1, Point p2, int thickness) {
        super.setPoints(new Point[]{p1, p2});
        this.thickness = thickness;
        updateLength();
        updatePerimeter();
        updateArea();
    }

    public Line(Point p1, Point p2) {
        super.setPoints(new Point[]{p1, p2});
        this.thickness = 1;
        updateLength();
        updatePerimeter();
        updateArea();
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
        updatePerimeter();
        updateArea();
    }

    public double getLength() {
        return length;
    }

    public void updateLength() {
        this.length = super.getPoints()[0].getDistance(super.getPoints()[1]);
    }

    public void updatePerimeter() {
        super.setPerimeter(this.length * 2 + this.thickness * 2);
    }

    public void updateArea() {
        super.setArea(this.length * this.thickness);
    }

    public double getSteeringRatio() {
        return ((super.getPoints()[1].getY() - super.getPoints()[0].getY()) / (super.getPoints()[1].getX() - super.getPoints()[0].getX()));
    }

    public double getAngleXAxis() {
        return Math.atan(this.getSteeringRatio());
    }

    public double getOrderedAtOrigin() {
        return super.getPoints()[1].getY() - this.getSteeringRatio() * super.getPoints()[1].getX();
    }

    @Override
    public void homothety(Point p, double ratio) {
        super.homothety(p, ratio);
        updateLength();
        updatePerimeter();
        updateArea();
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
