package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.*;
import com.example.tinexchain.repository.DeliveryContainsProductRepository;
import com.example.tinexchain.service.DeliveryContainsProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryContainsProductServiceImpl implements DeliveryContainsProductService {

    private final DeliveryContainsProductRepository deliveryContainsProductRepository;

    public DeliveryContainsProductServiceImpl(DeliveryContainsProductRepository deliveryContainsProductRepository) {
        this.deliveryContainsProductRepository = deliveryContainsProductRepository;
    }


    @Override
    public List<DeliveryContainsProduct> listAll() {
        return deliveryContainsProductRepository.findAll();
    }

    @Override
    public Optional<DeliveryContainsProduct> getQuantityForDeliveryAndProduct(Delivery delivery, Product product) {
        return Optional.of(deliveryContainsProductRepository.findByDeliveryAndProduct(delivery,product));
    }

    @Override
    public void addProductToDeliivery(Delivery delivery, Product product, int quantity) {
        DeliveryContainsProductKey key = new DeliveryContainsProductKey();

        key.setDelivery_Id(delivery.getDelivery_Id());
        key.setProduct_Id(product.getProduct_ID());

        DeliveryContainsProduct deliveryContainsProduct = new DeliveryContainsProduct();
        deliveryContainsProduct.setDelivery(delivery);
        deliveryContainsProduct.setDelivery_contains_product_id(key);
        deliveryContainsProduct.setProduct(product);
        deliveryContainsProduct.setQuantity(quantity);
        deliveryContainsProductRepository.save(deliveryContainsProduct);
    }


}
