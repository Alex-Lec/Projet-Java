package mural;

public abstract class Shape implements MuralComponents {
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
}
