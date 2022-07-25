package ss17_binaryfile_serialization.bai_tap.bai_1;
import java.io.Serializable;
import java.util.*;
public class Product implements Serializable {
    int id;
    String name;
    String manu;
    float price;
    public Product(){
        this.id = 0;
        this.name ="Mobile";
        this.manu = "Sam Sung";
        this.price = 1000;
    }
    public Product(int id,String name,String manu,float price){
        this.id = id;
        this.name = name;
        this.manu = manu;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manu='" + manu + '\'' +
                ", price=" + price +
                '}';
    }
}
