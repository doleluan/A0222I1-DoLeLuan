package codegym.product.repository;

import codegym.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
