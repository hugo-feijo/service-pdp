package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Category;
import com.pdp.servicepdp.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public Category findById(Integer id) {
        var category = categoryRepository.findById(id);
        if (category.isEmpty())
            throw new GlobalException("Category not found", HttpStatus.NOT_FOUND);
        return category.get();
    }
}
