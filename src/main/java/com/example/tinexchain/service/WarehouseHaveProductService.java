package com.example.tinexchain.service;

import com.example.tinexchain.model.*;

import java.util.List;
import java.util.Optional;

public interface WarehouseHaveProductService {
    List<WarehouseHaveProduct> listAll();

    Optional<WarehouseHaveProduct> getQuantityForWarehouseAndProduct(Warehouse warehouse, Product product);

    void update(Product product,Warehouse warehouse,int quantity);

}
