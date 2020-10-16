package mural;

public class Polygon extends Shape {
    private final Line[] lines;

    public Polygon(Point[] points) {
        super.setPoints(points);
        lines = new Line[points.length / 2 + 1];
        for (int i = 0; i < points.length; i++) {
            if (i == points.length - 1) {
                this.lines[i] = new Line(points[i], points[0]);
            } else {
                this.lines[i] = new Line(points[i], points[i + 1]);
            }
        }
        updateArea();
        updatePerimeter();
    }

    public Line[] getLines() {
        return lines;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;
        for (Line l : lines) {
            perimeter += l.getLength();
        }
        return perimeter;
    }

    public void updatePerimeter() {
        double perimeter = 0;
        for (Line l : lines) {
            perimeter += l.getLength();
        }
        super.setPerimeter(perimeter);
    }

    public void updateArea() {
        double area = 0;
        for (Line l : lines) {
            area += l.getPoints()[0].getX() * l.getPoints()[1].getY() - l.getPoints()[0].getX() * l.getPoints()[1].getY();
        }
        area *= 0.5;
        super.setArea(area);
    }

    @Override
    public void homothety(Point p, double ratio) {
        super.homothety(p, ratio);
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
