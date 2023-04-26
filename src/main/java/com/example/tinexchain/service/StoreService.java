package com.example.tinexchain.service;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    List<Store> listAll();
    Optional<Store> findStoreById(int id);
}
