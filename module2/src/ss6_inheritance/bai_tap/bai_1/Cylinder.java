package ss6_inheritance.bai_tap.bai_1;
import java.util.*;
public class Cylinder extends Circle{
    private double height;
    public Cylinder(){
        super();
        this.height = 5;
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + "Cylinder{" +
                "height=" + height +
                '}';
    }
    public double getArea(){
        return this.getRadius()*2*Math.PI*(this.getHeight()*this.getRadius());
    }
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        System.out.println(cy);
        System.out.println(cy.getColor());
        System.out.println(cy.getArea());
    }
}
