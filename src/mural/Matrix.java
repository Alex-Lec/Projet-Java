package mural;

public final class Matrix {
    public static double[][] homothetyMatrix(Point p, double ratio) {
        return new double[][]{{ratio, p.getY()}, {p.getX(), ratio}};
    }

    public static double[][] translationMatrix(double u, double v) {
        return new double[][]{{u}, {v}};
    }

    public static double[][] rotationMatrix(Point p, double angle, boolean pointXSupMarkerX) {
        double angleInRadians = Math.toRadians(angle);
        System.out.println(angle);
        if (pointXSupMarkerX) {
            return new double[][]{{Math.cos(angleInRadians), Math.sin(angleInRadians)}, {- Math.sin(angleInRadians), Math.cos(angleInRadians)}};
        }
        return new double[][]{{Math.cos(angleInRadians), - Math.sin(angleInRadians)}, {Math.sin(angleInRadians), Math.cos(angleInRadians)}};
    }

    public static double[][] axialSymmetryMatrix(double orderedAtOrigin, double angle) {
        double tanAngle = Math.tan(angle);
        double factor = 1 / (1 + Math.pow(tanAngle, 2));
        return new double[][]{{factor * (1 - Math.pow(tanAngle, 2)), factor * 2 * tanAngle, factor * (-2 * orderedAtOrigin * tanAngle)}, {factor * 2 * tanAngle, factor * (- (1 - Math.pow(tanAngle, 2))), factor * 2 * orderedAtOrigin}, {0, 0, factor * (1 + Math.pow(tanAngle, 2))}};
    }
}