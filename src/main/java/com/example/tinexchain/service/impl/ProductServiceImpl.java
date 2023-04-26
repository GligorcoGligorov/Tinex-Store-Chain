package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Store;
import com.example.tinexchain.repository.ProductRepository;
import com.example.tinexchain.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findProductById(int id) {
        return repository.findById(id);
    }


}
