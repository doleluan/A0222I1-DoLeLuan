package codegym.product.services;

import codegym.product.model.Product;

import java.util.List;

public interface IProductServices {
    List<Product> getAll();

    void save(Product product);

    Product getProductById(int id);

    void delete(Product product);
}
