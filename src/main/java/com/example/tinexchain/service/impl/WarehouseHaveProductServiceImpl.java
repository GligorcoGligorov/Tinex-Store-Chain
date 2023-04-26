package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.StoreHaveProduct;
import com.example.tinexchain.model.Warehouse;
import com.example.tinexchain.model.WarehouseHaveProduct;
import com.example.tinexchain.repository.WarehouseHaveProductRepository;
import com.example.tinexchain.service.WarehouseHaveProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseHaveProductServiceImpl implements WarehouseHaveProductService {

    private final WarehouseHaveProductRepository warehouseHaveProductRepository;

    public WarehouseHaveProductServiceImpl(WarehouseHaveProductRepository warehouseHaveProductRepository) {
        this.warehouseHaveProductRepository = warehouseHaveProductRepository;
    }

    @Override
    public List<WarehouseHaveProduct> listAll() {
        return warehouseHaveProductRepository.findAll();
    }

    @Override
    public Optional<WarehouseHaveProduct> getQuantityForWarehouseAndProduct(Warehouse warehouse, Product product) {
        return Optional.of(warehouseHaveProductRepository.findByWarehouseAndProduct(warehouse,product));
    }

    @Override
    public void update(Product product, Warehouse warehouse, int quantity) {
        WarehouseHaveProduct warehouseHaveProduct = warehouseHaveProductRepository.findByWarehouseAndProduct(warehouse,product);
        warehouseHaveProduct.setQuantity(warehouseHaveProduct.getQuantity() - quantity);
        warehouseHaveProductRepository.save(warehouseHaveProduct);
    }
}
