package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_contains")
public class DeliveryContainsProduct {

    @Id
    DeliveryContainsProductKey delivery_contains_product_id;

    @ManyToOne
    @MapsId("delivery_Id")
    @JoinColumn(name = "delivery_id")
    Delivery delivery;

    @ManyToOne
    @MapsId("product_Id")
    @JoinColumn(name = "product_id")
    Product product;


    @Column(name = "quantity")
    private int quantity;
}
