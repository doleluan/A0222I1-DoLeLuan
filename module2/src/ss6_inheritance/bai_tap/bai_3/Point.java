package ss6_inheritance.bai_tap.bai_3;
import java.util.*;
public class Point {
    protected float x = 0.0f;
    protected float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] temp ={this.x,this.y};
        return temp;
    }
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
    public static void main(String[] args) {
        Point p1 = new Point(5,5);
        System.out.println(p1);
    }
}
