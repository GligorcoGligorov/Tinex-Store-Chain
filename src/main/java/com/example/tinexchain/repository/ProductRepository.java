package com.example.tinexchain.repository;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


}
