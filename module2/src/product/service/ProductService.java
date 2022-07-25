package product.service;

import product.exception.NotFoundException;
import product.models.Product;
import product.util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    static List<Product> products = new ArrayList<>();
    private static String PATH ="D:\\A0222I1-DoLeLuan\\module2\\src\\product\\data\\data.csv";
    static ReadAndWrite readAndWrite = new ReadAndWrite();
    public ProductService(){
        products = readAndWrite.readProduct();
    }
    public void create(Product product){
        int lastId =0;
        if (products.size()>0){
            lastId = products.get(products.size()-1).getId();
        }
        product.setId(lastId+1);
        products.add(product);
        readAndWrite.writeToFile(PATH,products);
    }
    public List<Product> findAll(){
        return products;
    }
    public void delete(int id) throws NotFoundException {
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                products.remove(i);
                readAndWrite.writeToFile(PATH,products);
                return;
            }
        }
        throw new NotFoundException("Loi xoa");
    }
}
