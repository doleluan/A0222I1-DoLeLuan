package ss6_inheritance.bai_tap.bai_3;
import java.util.*;
public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(){
        super();
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void  setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float [] temp = {this.xSpeed,this.ySpeed};
        return temp;
    }
    public String toString(){
        return super.toString()+","+"speed = ("+this.xSpeed+","+this.ySpeed+")";
    }
    public MoveablePoint move(){
        this.x+=xSpeed;
        this.y +=ySpeed;
        return this;
    }
    public static void main(String[] args) {
        MoveablePoint mo = new MoveablePoint();
        System.out.println(mo);
        mo.setSpeed(10,10);
        System.out.println(mo);
        System.out.println(mo.move());
        System.out.println(mo);
    }
}
