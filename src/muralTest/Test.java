package muralTest;

import mural.*;

import java.io.PipedInputStream;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes1 = new Shape[]{new Line(new Point(1, 1), new Point(2, 1), 2)};
        Shape[] shapes2 = new Shape[]{new Ellipsis(new Point(2, 2), 3, 2)};
        Shape[] shapes3 = new Shape[]{new Polygon(new Point[]{new Point(1, 1), new Point(2, 2), new Point(3, 1)})};
        Shape[] shapes4 = new Shape[]{new Circle(new Point(2, 2), 2)};
        Picture p1 = new Picture(shapes1);
        Picture p2 = new Picture(shapes2);
        Picture p3 = new Picture(shapes3);
        Picture p4 = new Picture(shapes4);
        Picture[] pictures1 = new Picture[]{p1, p2};
        Picture[] pictures2 = new Picture[]{p3, p4};
        Drawing d1 = new Drawing(pictures1);
        Drawing d2 = new Drawing(pictures2);
        Mural m = new Mural(new Drawing[]{d1, d2});
        System.out.println(m.toString());

        /*
        Point homothetyPoint = new Point(-1, -1);
        d1.homothety(homothetyPoint, 2);
        d2.homothety(homothetyPoint, 2);

        double[][] translationMatrix = Matrix.translationMatrix(2, 4);
        d1.translation(translationMatrix);
        d2.translation(translationMatrix);

        Point centralSymmetryPoint = new Point(6, 6);
        d1.centralSymmetry(centralSymmetryPoint);
        d2.centralSymmetry(centralSymmetryPoint);

        Line axialSymmetryLine = new Line(new Point(3, 3), new Point(4, 4));
        d1.axialSymmetry(axialSymmetryLine);
        d2.axialSymmetry(axialSymmetryLine);

        p1.sort();
        p2.sort();

        d1.sort();
        d2.sort();

        System.out.println(m.toString());
        */
    }
}
