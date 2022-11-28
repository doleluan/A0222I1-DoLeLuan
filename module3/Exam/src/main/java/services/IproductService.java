package services;

import model.Product;

import java.util.List;
import java.util.Map;

public interface IproductService {
    List<Product> findAll();
    Map<String,String> add(Product product);
    boolean deletebyId(int id);
    Product findById(int id);
    List<Product> search(String find);
}
