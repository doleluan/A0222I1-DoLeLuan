package codegym.product_management.services.impl;

import codegym.product_management.model.Product;
import codegym.product_management.repository.IProductRepository;
import codegym.product_management.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page getAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
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

    @Override
    public Page<Product> findByName(String name,Pageable pageable) {
        return iProductRepository.findByNameContains(name, pageable);
    }
}
