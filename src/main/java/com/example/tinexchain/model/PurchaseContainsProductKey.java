package com.example.tinexchain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PurchaseContainsProductKey implements Serializable {

    @Column(name = "purchase_id")
    private Long purchase_Id;

    @Column(name = "product_id")
    private Long product_Id;

    public void setPurchase_Id(Long purchase_Id) {
        this.purchase_Id = purchase_Id;
    }

    public void setProduct_Id(Long product_Id) {
        this.product_Id = product_Id;
    }
}