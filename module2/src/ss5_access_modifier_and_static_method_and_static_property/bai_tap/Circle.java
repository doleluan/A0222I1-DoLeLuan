package ss5_access_modifier_and_static_method_and_static_property.bai_tap;
import java.util.*;
public class Circle {
    private double radius = 1.0;
    private String color = "red";
    public Circle(){
        this.color = "red";
        this.radius = 20;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return  this.radius;
    }
    public Double getArea(){
        return Math.pow(this.radius,2)* Math.PI;
    }
    public static void main(String[] args) {

    }
}
