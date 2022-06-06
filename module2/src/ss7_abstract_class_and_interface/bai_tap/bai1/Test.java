package ss7_abstract_class_and_interface.bai_tap.bai1;

public class Test {
    public static double aaa(double a){
        return a;
    }
    public static void main(String[] args) {
            Resizeable[] resizeable= new Resizeable[3];
            resizeable[0]= new Circle(5, "red", true);
            resizeable[1]= new Rectangle("yellow", false, 5, 9);
            resizeable[2]= new Square(15,"blue", false);

            for (Resizeable e: resizeable){
                if(e instanceof Circle){
                    e.resize(100);
                    System.out.println(e);
                }
                else if(e instanceof Rectangle){
                    e.resize(300);
                    System.out.println(e);
                }
                else if(e instanceof Square){
                    e.resize(200);
                    System.out.println(e);
                }
            }
    }
}
