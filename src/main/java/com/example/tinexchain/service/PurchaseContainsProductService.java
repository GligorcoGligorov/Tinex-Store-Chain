package com.example.tinexchain.service;

import com.example.tinexchain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseContainsProductService {
    List<PurchaseContainsProduct> listAll();

    Optional<PurchaseContainsProduct> getQuantityForPurchaseAndProduct(Purchase purchase, Product product);
    void addProductToPurchase(Purchase purchase,Product product,int q);
}
