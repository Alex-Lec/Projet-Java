package mural;

import java.util.*;

public class Picture implements MuralComponents, Iterable<Shape>, Comparable<Picture> {
    private Set<Shape> shapeSet;

    public Picture(Shape[] s) {
        this.shapeSet = new HashSet<>(Arrays.asList(s));
    }

    public Set<Shape> getShapeSet() {
        return shapeSet;
    }

    @Override
    public Iterator<Shape> iterator() {
        return this.shapeSet.iterator();
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;
        for (Shape s : this) {
            perimeter += s.getPerimeter();
        }
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = 0;
        for (Shape s : this) {
            area += s.getArea();
        }
        return area;
    }

    @Override
    public int compareTo(Picture p) {
        double areaDifference = this.getArea() - p.getArea();
        if (areaDifference > 0) {
            return 1;
        } else if(areaDifference < 0) {
            return -1;
        }
        return 0;
    }

    public void sort() {
        this.shapeSet = new TreeSet<>(this.shapeSet);
    }

    @Override
    public String toString() {
        return "Picture";
    }

    @Override
    public void homothety(Point p, double ratio) {
        for (Shape s : this) {
            s.homothety(p, ratio);
        }
    }

    @Override
    public void translation(double[][] matrix) {
        for (Shape s : this) {
            s.translation(matrix);
        }
    }

    @Override
    public void rotation(Point p, int angle) {
        for (Shape s : this) {
            s.rotation(p, angle);
        }
    }

    @Override
    public void centralSymmetry(Point p) {
        for (Shape s : this) {
            s.centralSymmetry(p);
        }
    }

    @Override
    public void axialSymmetry(Line l) {
        for (Shape s : this) {
            s.axialSymmetry(l);
        }
    }
}
