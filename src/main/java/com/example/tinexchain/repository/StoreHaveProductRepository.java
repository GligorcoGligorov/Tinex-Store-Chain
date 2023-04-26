package com.example.tinexchain.repository;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Store;
import com.example.tinexchain.model.StoreHaveProduct;
import com.example.tinexchain.model.StoreHaveProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreHaveProductRepository extends JpaRepository<StoreHaveProduct, StoreHaveProductKey> {
    StoreHaveProduct findByStoreAndProduct(Store store, Product product);
}
