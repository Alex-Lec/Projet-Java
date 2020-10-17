package mural;

import java.util.Arrays;
import java.util.Objects;

public abstract class Shape implements MuralComponents, Comparable<Shape> {
    private Point[] points;
    private double perimeter, area;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "points = " + Arrays.toString(points) +
                ", perimeter = " + perimeter +
                ", area = " + area;
    }

    @Override
    public int compareTo(Shape s) {
        double perimeterDifference = this.perimeter - s.getPerimeter();
        if (perimeterDifference > 0) {
            return 1;
        } else if (perimeterDifference < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return Double.compare(shape.getPerimeter(), getPerimeter()) == 0 &&
                Double.compare(shape.getArea(), getArea()) == 0 &&
                Arrays.equals(getPoints(), shape.getPoints());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getPerimeter(), getArea());
        result = 31 * result + Arrays.hashCode(getPoints());
        return result;
    }

    @Override
    public void homothety(Point p, double ratio) {
        for (Point pt : points) {
            pt.homothety(p, ratio);
        }
    }

    @Override
    public void translation(double[][] matrix) {
        for (Point p : points) {
            p.translation(matrix);
        }
    }

    @Override
    public void rotation(Point p, int angle) {
        for (Point pt : points) {
            pt.rotation(p, angle);
        }
    }

    @Override
    public void centralSymmetry(Point p) {
        for (Point pt : points) {
            pt.centralSymmetry(p);
        }
    }

    @Override
    public void axialSymmetry(Line l) {
        for (Point p : points) {
            p.axialSymmetry(l);
        }
    }

    public abstract Shape copy();
}
