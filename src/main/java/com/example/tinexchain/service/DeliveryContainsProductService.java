package com.example.tinexchain.service;

import com.example.tinexchain.model.*;

import java.util.List;
import java.util.Optional;

public interface DeliveryContainsProductService {

    List<DeliveryContainsProduct> listAll();

    Optional<DeliveryContainsProduct> getQuantityForDeliveryAndProduct(Delivery delivery, Product product);
    void addProductToDeliivery(Delivery delivery,Product product,int quantity);
}
