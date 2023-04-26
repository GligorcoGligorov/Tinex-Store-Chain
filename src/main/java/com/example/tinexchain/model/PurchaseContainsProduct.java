package com.example.tinexchain.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "purchase_contains")
public class PurchaseContainsProduct {

    @Id
    PurchaseContainsProductKey purchaseContainsProductKey;

    @ManyToOne
    @MapsId("purchase_Id")
    @JoinColumn(name = "purchase_id")
    Purchase purchase;

    @ManyToOne
    @MapsId("product_Id")
    @JoinColumn(name = "product_id")
    Product product;


    @Column(name = "quantity")
    private int quantity;
}
