package com.example.tinexchain.service;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Store;
import com.example.tinexchain.model.StoreHaveProduct;

import java.util.List;
import java.util.Optional;

public interface StoreHaveProductService {

    List<StoreHaveProduct> listAll();
    void updateAdd(Store store,Product product,int quantity);

    void update(Store store,Product product,int quantity);
    Optional<StoreHaveProduct> getQuantityForStoreAndProduct(Store store, Product product);
}
