package com.example.tinexchain.repository;

import com.example.tinexchain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseContainsProductRepository extends JpaRepository<PurchaseContainsProduct, PurchaseContainsProductKey> {
    PurchaseContainsProduct findByPurchaseAndProduct(Purchase purchase, Product product);

}
