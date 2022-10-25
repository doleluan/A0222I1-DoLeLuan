package codegym.product_management.services;


import codegym.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductServices {
    List<Product> getAll();

    Page getAll(Pageable pageable);
    void save(Product product);

    Product getProductById(int id);

    void delete(Product product);
    Page<Product> findByName(String name, Pageable pageable);
}
