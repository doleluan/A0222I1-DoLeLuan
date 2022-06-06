package ss6_inheritance.thuc_hanh.bai1;

public class Circle  extends Shape {
    private double radius;
    public Circle(){
        this.radius = 1;
    }
    public Circle(String color,boolean filled, double radius){
        super(color, filled);
        this.radius = radius;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
    public double getPerimeter(){
        return  this.radius*2*Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString(){
        return "A Rectangle with width = " + this.getRadius() + ", which is a subclass of "+ super.toString();
    }
    public static void main(String[] args) {

    }
}
