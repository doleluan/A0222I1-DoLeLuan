package ss6_inheritance.thuc_hanh.bai1;
import java.util.*;
public class Shape {
    private String color ;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    private boolean filled;
    public Shape(){
        this.color = "green";
        this.filled = true;
    }
    public Shape(String color,boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}
