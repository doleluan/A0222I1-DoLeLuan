package codegym.repository.impl;

import codegym.model.Product;
import codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Iphone12",20000000f,"Black","Apple"));
        products.add(new Product(2,"SamSung S22 Ultra",30000000f,"Black","Apple"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }
    @Override
    public void update(Product product) {
        int lastId =1;
        if (products.size()>0){
            lastId = products.get(products.size()-1).getId()+1;
        }
        if (product.getId()==null){
            product.setId(lastId);
            products.add(product);
        }else {
            for (int i =0;i<products.size();i++){
                if (products.get(i).getId()==product.getId()){
                    products.set(i,product);
                    break;
                }
            }
        }

    }

    @Override
    public Product findById(Integer id) {
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(Product product) {
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==product.getId()){
                products.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (int i=0;i<products.size();i++){
            if (products.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                productList.add(products.get(i));
            }
        }
        return productList;
    }
}
