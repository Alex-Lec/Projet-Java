package mural;

public class Point implements GeometricTransformations {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }

    public Point copy() {
        return new Point(this.x, this.y);
    }

    @Override
    public void homothety(Point p, double ratio) {
        double[][] matrix = Matrix.homothetyMatrix(p, ratio);
        double oldX = this.x;
        double oldY = this.y;
        this.x = matrix[0][0] * oldX + matrix[0][1] * oldY;
        this.y = matrix[1][0] * oldX + matrix[1][1] * oldY;
    }

    @Override
    public void translation(double[][] matrix) {
        this.x = this.x + matrix[0][0];
        this.y = this.y + matrix[1][0];
    }

    @Override
    public void rotation(Point p, int angle) {
        double[][] matrix;
        if (this.x >= p.getX()) {
            matrix = Matrix.rotationMatrix(p, angle, true);
        } else {
            matrix = Matrix.rotationMatrix(p, - angle, false);
        }
        double oldX = this.x - p.getX();
        double oldY = this.y - p.getY();
        this.x = matrix[0][0] * oldX + matrix[0][1] * oldY + p.getX();
        this.y = matrix[1][0] * oldX + matrix[1][1] * oldY + p.getY();
    }

    @Override
    public void centralSymmetry(Point p) {
        this.homothety(p, -1);
    }

    @Override
    public void axialSymmetry(Line l) {
        double[][] matrix = Matrix.axialSymmetryMatrix(l.getOrderedAtOrigin(), l.getAngleXAxis());
        double oldX = this.x;
        double oldY = this.y;
        this.x = Math.round(matrix[0][0] * oldX + matrix[0][1] * oldY + matrix[0][2]);
        this.y = Math.round(matrix[1][0] * oldX + matrix[1][1] * oldY + matrix[1][2]);
    }
}
