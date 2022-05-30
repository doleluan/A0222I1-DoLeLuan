package ss6_inheritance.bai_tap.bai_2;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2,3);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));

        Point3D point3D = new Point3D(4,5,6);
        System.out.println(point3D);
        System.out.println(Arrays.toString(point3D.getXYZ()));
    }
}
