package com.example.swaggerexample.controller;
import com.example.swaggerexample.SwaggerExampleApplication;
import com.example.swaggerexample.api.CategoriesApi;
import com.example.swaggerexample.models.CategoryModel;
import com.example.swaggerexample.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController implements CategoriesApi {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Void> addCategory(@Valid CategoryModel categoryModel) {
        categoryService.addCategory(categoryModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Long categoryId) {
        Integer numberDelete = categoryService.deleteCategory(categoryId);
        if(numberDelete.equals(1)) {
            logger.debug("Category ID equals 1, return OK");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            logger.debug("Category ID not equals 1, return NOT_FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
}
