package codegym.repository.impl;

import codegym.model.Product;
import codegym.repository.IProductRepository;
import codegym.services.IProductServices.impl.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("from product ",Product.class).getResultList();
        return  products;
    }
    @Override
    public void update(Product product) {
//        int lastId =1;
//        if (products.size()>0){
//            lastId = products.get(products.size()-1).getId()+1;
//        }
//        if (product.getId()==null){
//            product.setId(lastId);
//            products.add(product);
//        }else {
//            for (int i =0;i<products.size();i++){
//                if (products.get(i).getId()==product.getId()){
//                    products.set(i,product);
//                    break;
//                }
//            }
//        }
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public void delete(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (int i=0;i<products.size();i++){
            if (products.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                products.add(products.get(i));
            }
        }
        return products;
    }
}
