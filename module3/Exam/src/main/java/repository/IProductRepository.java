package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void add(Product product);
    List<Product> search(String find);
    boolean deletebyId(int id);
    Product findById(int id);
}
