package codegym.product_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name ="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;
    public List<Product> getProducts(){
        return  products;
    }
    public  void setProduct (List<Product> products){
        this.products = products;
    }
    public Category(){

    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
