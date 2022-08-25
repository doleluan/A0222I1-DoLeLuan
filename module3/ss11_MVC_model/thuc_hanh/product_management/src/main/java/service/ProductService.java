package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll();
    Map<String,String> create (Product product);
    boolean update (Product product);
    void remove(int id);
    Product findById(int id);
    List<Product> findByName(String name);
}
