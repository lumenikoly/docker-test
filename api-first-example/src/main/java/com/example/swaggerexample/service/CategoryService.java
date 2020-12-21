package com.example.swaggerexample.service;

import com.example.swaggerexample.mapper.CategoryMapper;
import com.example.swaggerexample.models.CategoryModel;
import com.example.swaggerexample.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryModel addCategory(CategoryModel categoryModel) {
        categoryRepository.save(CategoryMapper.toEntity(categoryModel));
        return categoryModel;
    }

    @Transactional
    public Integer deleteCategory(Long categoryId) {
        return categoryRepository.deleteById(categoryId);
    }

    public List<CategoryModel> getAllCategories() {
        return CategoryMapper.toApi(categoryRepository.findAll());
    }
}
