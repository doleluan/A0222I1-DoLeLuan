package codegym.product_management.repository;

import codegym.product_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
@Transactional
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
