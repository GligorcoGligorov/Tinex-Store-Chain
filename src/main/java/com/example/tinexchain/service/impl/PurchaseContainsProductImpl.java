package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Purchase;
import com.example.tinexchain.model.PurchaseContainsProduct;
import com.example.tinexchain.model.PurchaseContainsProductKey;
import com.example.tinexchain.repository.PurchaseContainsProductRepository;
import com.example.tinexchain.service.PurchaseContainsProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseContainsProductImpl implements PurchaseContainsProductService {
    private final PurchaseContainsProductRepository productRepository;

    public PurchaseContainsProductImpl(PurchaseContainsProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<PurchaseContainsProduct> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<PurchaseContainsProduct> getQuantityForPurchaseAndProduct(Purchase purchase, Product product) {
        return Optional.of(productRepository.findByPurchaseAndProduct(purchase,product));
    }

    @Override
    public void addProductToPurchase(Purchase purchase,Product product, int q) {
        PurchaseContainsProductKey key = new PurchaseContainsProductKey();
        key.setPurchase_Id(purchase.getPurchase_id());
        key.setProduct_Id(product.getProduct_ID());

        PurchaseContainsProduct purchaseContainsProduct = new PurchaseContainsProduct();
        purchaseContainsProduct.setPurchaseContainsProductKey(key);
        purchaseContainsProduct.setProduct(product);
        purchaseContainsProduct.setPurchase(purchase);
        purchaseContainsProduct.setQuantity(q);
        productRepository.save(purchaseContainsProduct);
    }
}
