package com.example.tinexchain.service;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Store;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> listAll();
    Optional<Product> findProductById(int id);

}
