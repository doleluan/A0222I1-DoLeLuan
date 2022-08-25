package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static List<Product>  products;
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Xiaomi 11T Pro 5G",15,"Xiaomi"));
        products.add(new Product(2,"Sam Sung U22 Ultra",30000000,"SamSung"));
        products.add(new Product(3,"IPhone 14 Plus Pro Max",50000000,"Apple"));
        products.add(new Product(4,"Xiaomi Black Shark 5",30000000,"Xiaomi"));
        products.add(new Product(5,"Nokia Z12",8000000,"Nokia"));
        products.add(new Product(6,"Redmi K20",15000000,"Xiaomi"));
        products.add(new Product(7,"Sam Sung J7",5000000,"Sam Sung"));
        products.add(new Product(8,"IPhone 12 Plus Pro Max",15000000,"Apple"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }
    @Override
    public  Map<String,String>create(Product product) {
        Map<String,String> map = new HashMap<>();
        if (product.getPrice()<=0){
            map.put("price","Gia khong the nho hon 0");
        }
        if ("".equals(product.getName())){
            map.put("name","Name khong duoc trong");
        }
        if ("".equals(product.getManufactor())){
            map.put("name","Nha san xuat khong duoc trong");
        }
        if (map.isEmpty()){
            products.add(product);
        }
        return map;
    }
    @Override
    public boolean update(Product product) {
        products.add(product);
        return true;
    }
    @Override
    public void remove(int id) {
        for(int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                products.remove(i);
            }
        }
    }
    @Override
    public Product findById(int id) {
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id)
                return products.get(i);
        }
        return null;
    }
    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for (int i=0;i<products.size();i++){
//            if (products.get(i).getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())){
            if (products.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                Product product = products.get(i);
                list.add(product);
            }
        }
        return list;
    }
}
