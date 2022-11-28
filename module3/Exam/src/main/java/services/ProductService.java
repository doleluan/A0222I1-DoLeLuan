package services;

import common.Validation;
import model.Product;
import repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IproductService{
    private ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public Map<String, String> add(Product product) {
        Map <String,String> map = new HashMap<>();
        if (product.getQuantity()<=0){
            map.put("quantity","So luong phai lon hon 0");
        }
        if (product.getPrice()<=0){
            map.put("price","Gia phai lon hon 0");
        }if ("".equals(product.getName())){
            map.put("name","Ten khong duoc bo trong");
        }
        if ("".equals(product.getColor())){
            map.put("color","Mau khong duoc de trong");
        }else  if (!Validation.checkColor(product.getColor())){
            map.put("color","Mau khong dung dinh dang");
        }
        if ("".equals(product.getDescription())){
            map.put("des","Mo ta khong duoc de trong ");
        }
        if (map.isEmpty()){
            productRepository.add(product);
        }
        return map;
    }
    @Override
    public boolean deletebyId(int id) {
        return productRepository.deletebyId(id);
    }
    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
    @Override
    public List<Product> search(String find) {
        return productRepository.search(find);
    }
}
