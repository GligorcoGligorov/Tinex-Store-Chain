package com.example.tinexchain.service;

import com.example.tinexchain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> listAll();
//    List<Category> listAllSurCategories(Category category);
    Optional<Category> findCategoryById(int id);
}
