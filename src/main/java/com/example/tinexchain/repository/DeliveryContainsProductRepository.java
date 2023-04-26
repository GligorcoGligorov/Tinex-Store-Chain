package com.example.tinexchain.repository;

import com.example.tinexchain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryContainsProductRepository extends JpaRepository<DeliveryContainsProduct,DeliveryContainsProductKey> {

        DeliveryContainsProduct findByDeliveryAndProduct(Delivery delivery, Product product);
}
