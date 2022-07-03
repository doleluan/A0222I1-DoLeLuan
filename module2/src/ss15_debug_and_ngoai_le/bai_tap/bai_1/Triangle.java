package ss15_debug_and_ngoai_le.bai_tap.bai_1;
import java.util.*;
public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    // if runtime no nedd throws
    Triangle(double side1, double side2, double side3) throws Exception {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        if(side1 <0 || side2<0 || side3<0){
            throw new Exception("Side cannot less than 0");

        }

        if(side1+ side2 < side3 || side1+ side3 < side2|| side2 + side3 < side1){
            throw new IllegalTriangleException("Sum of 2 side cannot less than remind side");
        }

    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public static void main(String[] args) throws Exception {
       try{
           Triangle tri = new Triangle(0,1,2);
       }catch (IllegalTriangleException e){
           e.printStackTrace();
       }
    }
}


