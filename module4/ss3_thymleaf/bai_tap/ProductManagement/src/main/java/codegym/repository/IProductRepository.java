package codegym.repository;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void update(Product product);
    Product findById(Integer id);
    void delete(Product product);
    List<Product> searchByName(String name);
}
