package ss7_abstract_class_and_interface.thuc_hanh.bai1;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound(){
        return "Chicken: cluck-cluck!";
    }
    public String howToEat(){
        return "could be fried";
    }
    public static void main(String[] args) {

    }
}
