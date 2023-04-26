package com.example.tinexchain.repository;

import com.example.tinexchain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

//    List<Category> findSurCategories(Category category);
}
