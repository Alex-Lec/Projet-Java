package mural;

public interface GeometricTransformations {
    void homothety(Point p, double ratio);
    void translation(double[][] matrix);
    void rotation(Point p, int angle);
    void centralSymmetry(Point p);
    void axialSymmetry(Line l);
}
