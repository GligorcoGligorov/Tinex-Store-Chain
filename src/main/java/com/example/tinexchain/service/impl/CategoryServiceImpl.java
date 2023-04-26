package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Category;
import com.example.tinexchain.repository.CategoryRepository;
import com.example.tinexchain.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(int id) {
        return categoryRepository.findById(id);
    }

//    @Override
//    public List<Category> listAllSurCategories(Category category) {
//        return categoryRepository.findSurCategories(category);
//    }


}
