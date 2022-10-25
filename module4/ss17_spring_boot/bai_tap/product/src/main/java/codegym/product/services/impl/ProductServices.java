package codegym.product.services.impl;

import codegym.product.model.Product;
import codegym.product.repository.IProductRepository;
import codegym.product.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices implements IProductServices {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Product product) {
        iProductRepository.delete(product);
    }
}
