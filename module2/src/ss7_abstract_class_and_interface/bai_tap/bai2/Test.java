package ss7_abstract_class_and_interface.bai_tap.bai2;

public class Test {
    public static void main(String[] args) {
        Shape [] shapes = new Shape[3];
        shapes[0] = new Rectangle();
        shapes[1] = new Circle();
        shapes[2] = new Square();
        for (Shape sp : shapes){
            System.out.println(sp);
            if (sp instanceof Square){
                 ((Square) sp).howToColor();
            }
        }

    }
}
