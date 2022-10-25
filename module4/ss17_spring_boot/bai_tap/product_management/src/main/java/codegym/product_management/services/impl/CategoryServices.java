package codegym.product_management.services.impl;
import codegym.product_management.model.Category;
import codegym.product_management.repository.ICategoryRepository;
import codegym.product_management.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices implements ICategoryServices {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> getAll() {
        return iCategoryRepository.findAll();
    }
}
