package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Store;
import com.example.tinexchain.model.StoreHaveProduct;
import com.example.tinexchain.repository.StoreHaveProductRepository;
import com.example.tinexchain.service.StoreHaveProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreHaveProductServiceImpl implements StoreHaveProductService {

    private final StoreHaveProductRepository storeHaveProductRepository;

    public StoreHaveProductServiceImpl(StoreHaveProductRepository storeHaveProductRepository) {
        this.storeHaveProductRepository = storeHaveProductRepository;
    }


    @Override
    public List<StoreHaveProduct> listAll() {
        return storeHaveProductRepository.findAll();
    }

    @Override
    public void update(Store store, Product product, int quantity) {
        StoreHaveProduct storeHaveProduct = storeHaveProductRepository.findByStoreAndProduct(store, product);
        storeHaveProduct.setQuantity(storeHaveProduct.getQuantity() - quantity);
        storeHaveProductRepository.save(storeHaveProduct);
    }

    @Override
    public void updateAdd(Store store, Product product, int quantity) {
        StoreHaveProduct storeHaveProduct = storeHaveProductRepository.findByStoreAndProduct(store, product);
        storeHaveProduct.setQuantity(storeHaveProduct.getQuantity() + quantity);
        storeHaveProductRepository.save(storeHaveProduct);
    }

    @Override
    public Optional<StoreHaveProduct> getQuantityForStoreAndProduct(Store store, Product product) {
        return Optional.of(storeHaveProductRepository.findByStoreAndProduct(store, product));
    }
}
