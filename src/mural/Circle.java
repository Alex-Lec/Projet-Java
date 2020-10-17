package mural;

import java.util.Arrays;
import java.util.Objects;

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

    public Circle copy() {
        return new Circle(this.getPoints()[0].copy(), this.radius);
    }

    @Override
    public String toString() {
        return "Circle : point = [" + super.getPoints()[0] + "], perimeter = " + super.getPerimeter() + ", area = " + super.getArea() + ", radius = " + this.radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRadius());
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
