package mural;

import java.util.Objects;

public class Ellipsis extends Shape {
    private double halfMajorAxis, halfMinorAxis;

    public Ellipsis(Point middle, double halfMajorAxis, double halfMinorAxis) {
        super.setPoints(new Point[]{middle, new Point(middle.getX() + halfMajorAxis, middle.getY()), new Point(middle.getX(), middle.getY() + halfMinorAxis)});
        this.halfMajorAxis = halfMajorAxis;
        this.halfMinorAxis = halfMinorAxis;
        updatePerimeter();
        updateArea();
    }

    public double getHalfMajorAxis() {
        return halfMajorAxis;
    }

    public void updateHalfMajorAxis() {
        this.halfMajorAxis = super.getPoints()[0].getDistance(super.getPoints()[1]);
    }

    public double getHalfMinorAxis() {
        return halfMinorAxis;
    }

    public void updateHalfMinorAxis() {
        this.halfMinorAxis = super.getPoints()[0].getDistance(super.getPoints()[2]);
    }

    public void updatePerimeter() {
        super.setPerimeter(2 * Math.PI * Math.sqrt((Math.pow(this.halfMajorAxis, 2) + Math.pow(this.halfMinorAxis, 2)) / 2));
    }

    public void updateArea() {
        super.setArea(Math.PI * this.halfMajorAxis * this.halfMinorAxis);
    }

    public Ellipsis copy() {
        return new Ellipsis(this.getPoints()[0].copy(), this.halfMajorAxis, this.halfMinorAxis);
    }

    @Override
    public String toString() {
        return "Ellipsis : " + super.toString() + ", halfMajorAxis = " + this.halfMajorAxis + ", halfMinorAxis = " + this.halfMinorAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipsis)) return false;
        if (!super.equals(o)) return false;
        Ellipsis ellipsis = (Ellipsis) o;
        return Double.compare(ellipsis.getHalfMajorAxis(), getHalfMajorAxis()) == 0 &&
                Double.compare(ellipsis.getHalfMinorAxis(), getHalfMinorAxis()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHalfMajorAxis(), getHalfMinorAxis());
    }

    @Override
    public void homothety(Point p, double ratio) {
        super.homothety(p, ratio);
        updateArea();
        updatePerimeter();
        updateHalfMajorAxis();
        updateHalfMinorAxis();
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
