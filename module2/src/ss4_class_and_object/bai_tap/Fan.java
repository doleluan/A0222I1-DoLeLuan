package ss4_class_and_object.bai_tap;
import java.util.*;
public class Fan {
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String toString(){
        if (isOn()){
            return "Speed: " + this.getSpeed() + ", Color: " + this.color + ", Radius: " + this.getRadius()
                    +" Fan is on";
        }else {
            return "Color: " + this.color + ", Radius: " + this.getRadius()
                    +" Fan is off";
        }
    }
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setColor("Yellow");
        fan1.setOn(true);
        fan1.setRadius(10);
        fan2.setSpeed(Fan.MEDIUM);
        System.out.println("Fan 1: " + fan1.toString());
        System.out.println("Fan 2: " + fan2.toString());
    }
}
