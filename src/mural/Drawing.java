package mural;

import java.util.*;

public class Drawing implements MuralComponents, Iterable<Picture> {
    private Set<Picture> pictureSet;

    public Drawing(Picture[] pictures) {
        this.pictureSet = new HashSet<>(Arrays.asList(pictures));
    }

    public Set<Picture> getPictureSet() {
        return pictureSet;
    }

    @Override
    public Iterator<Picture> iterator() {
        return this.pictureSet.iterator();
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;
        for (Picture p : this) {
            perimeter += p.getPerimeter();
        }
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = 0;
        for (Picture p : this) {
            area += p.getArea();
        }
        return area;
    }

    public void sort() {
        this.pictureSet = new TreeSet<>(this.pictureSet);
    }

    @Override
    public String toString() {
        return "Drawing";
    }

    @Override
    public void homothety(Point p, double ratio) {
        for (Picture pic : this) {
            pic.homothety(p, ratio);
        }
    }

    @Override
    public void translation(double[][] matrix) {
        for (Picture p : this) {
            p.translation(matrix);
        }
    }

    @Override
    public void rotation(Point p, int angle) {
        for (Picture pic : this) {
            pic.rotation(p, angle);
        }
    }

    @Override
    public void centralSymmetry(Point p) {
        for (Picture pic : this) {
            pic.centralSymmetry(p);
        }
    }

    @Override
    public void axialSymmetry(Line l) {
        for (Picture p : this) {
            p.axialSymmetry(l);
        }
    }
}
