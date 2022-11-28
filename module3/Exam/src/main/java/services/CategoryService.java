package services;

import model.Category;
import repository.CategoryRepository;
import repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements  ICategoryService{
    private ICategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
