package com.example.tinexchain.repository;

import com.example.tinexchain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseHaveProductRepository extends JpaRepository<WarehouseHaveProduct,WarehouseHaveProductKey> {

        WarehouseHaveProduct findByWarehouseAndProduct(Warehouse warehouse, Product product);
}
