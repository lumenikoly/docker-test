package com.example.swaggerexample.mapper;

import com.example.swaggerexample.entities.Category;
import com.example.swaggerexample.models.CategoryModel;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category toEntity(CategoryModel categoryModel) {
        return new Category(categoryModel.getTitle());
    }

    public static CategoryModel toApi(Category category) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(category.getId());
        categoryModel.setTitle(category.getTitle());

        return categoryModel;
    }

    public static List<CategoryModel> toApi(List<Category> categoryList) {
        return categoryList.stream()
                .map(CategoryMapper::toApi)
                .collect(Collectors.toList());
    }
}
