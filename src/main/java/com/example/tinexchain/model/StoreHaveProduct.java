package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StoreHaveProduct {

    @Id
    StoreHaveProductKey store_have_product_id;

    @ManyToOne
    @MapsId("store_Id")
    @JoinColumn(name = "store_id")
    Store store;

    @ManyToOne
    @MapsId("product_Id")
    @JoinColumn(name = "product_id")
    Product product;


    @Column(name = "quantity")
    private int quantity;
}
