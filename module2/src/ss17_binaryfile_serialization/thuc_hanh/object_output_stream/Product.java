package ss17_binaryfile_serialization.thuc_hanh.object_output_stream;

import java.io.Serializable;

public class Product implements Serializable {
    int id ;
    String name;
    float price;
    String status;
    public Product(int id, String name, float price, String status){
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
