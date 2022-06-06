package ss7_abstract_class_and_interface.thuc_hanh.bai2;

import ss6_inheritance.thuc_hanh.bai1.Circle;

public class ComparableCircle  extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }
    public ComparableCircle(double radius) {
        super(radius);
    }
    public ComparableCircle(String color, boolean filled,double radius) {
        super(color,filled ,radius );
    }
    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return -1;
        else if (getRadius() < o.getRadius()) return 1;
        else return -1;
    }
}