package ss12_java_collection_framework.bai_tap.bai1;
import java.util.*;
public class Product implements Comparable <Product> {
    private String name;
    private int id;
    private float price;
    public Product(int id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Product(){
        this.id = 1;
        this.name = "Laptop";
        this.price = 25.500f;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String toString(){
        return "Id: " + this.getId() + ", Name: " + this.getName() + ", Price: " + this.getPrice() + " VND";
    }

    public static void main(String[] args) {

    }

    @Override
    public int compareTo(Product o) {
        return (int)(price - o.getPrice());
    }
}
