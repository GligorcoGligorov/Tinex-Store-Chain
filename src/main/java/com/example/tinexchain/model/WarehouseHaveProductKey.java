package com.example.tinexchain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class WarehouseHaveProductKey implements Serializable {

    @Column(name = "warehouse_id")
    private Long warehouse_Id;

    @Column(name = "product_id")
    private Long product_Id;
}
