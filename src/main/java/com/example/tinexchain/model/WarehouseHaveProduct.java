package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WarehouseHaveProduct {

    @Id
    WarehouseHaveProductKey warehouse_have_product_id;


    @ManyToOne
    @MapsId("warehouse_Id")
    @JoinColumn(name = "warehouse_id")
    Warehouse warehouse;

    @ManyToOne
    @MapsId("product_Id")
    @JoinColumn(name = "product_id")
    Product product;


    @Column(name = "quantity")
    private int quantity;
}
