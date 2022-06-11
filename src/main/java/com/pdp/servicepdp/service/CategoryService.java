package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Category;
import com.pdp.servicepdp.repository.CategoryDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public Category create(Category category) {
        categoryDAO.create(category);
        return category;
    }

    public Category findById(Integer id) {
        var category = categoryDAO.read(Category.class, id);
        if (category == null)
            throw new GlobalException("Category not found", HttpStatus.NOT_FOUND);
        return category;
    }
}
