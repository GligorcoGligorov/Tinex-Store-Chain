package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Store;
import com.example.tinexchain.model.StoreHaveProduct;
import com.example.tinexchain.repository.ProductRepository;
import com.example.tinexchain.repository.StoreHaveProductRepository;
import com.example.tinexchain.repository.StoreRepository;
import com.example.tinexchain.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    private final StoreHaveProductRepository storeHaveProductRepository;

    public StoreServiceImpl(StoreRepository storeRepository, ProductRepository productRepository, StoreHaveProductRepository storeHaveProductRepository) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
        this.storeHaveProductRepository = storeHaveProductRepository;
    }



    @Override
    public List<Store> listAll() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> findStoreById(int id) {
        return storeRepository.findById(id);
    }




}
