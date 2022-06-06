package ss7_abstract_class_and_interface.thuc_hanh.bai1;

public class TestAnimal {
    public static void main(String[] args) {
        Animal[] animal = new Animal[2];
        animal[0] = new Tiger();
        animal[1] = new Chicken();
        for (Animal animal1 :animal){
            System.out.println(animal1.makeSound());
            if (animal1 instanceof Chicken) {
                Edible edibler = (Chicken) animal1;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
