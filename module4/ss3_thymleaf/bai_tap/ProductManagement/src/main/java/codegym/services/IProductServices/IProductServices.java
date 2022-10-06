package codegym.services.IProductServices;

import codegym.model.Product;

import java.util.List;

public interface IProductServices {
    List<Product> findAll();
    void update(Product product);
    Product findById(Integer id);
    void delete(Product product);
    List<Product> searchByName(String name);
}
