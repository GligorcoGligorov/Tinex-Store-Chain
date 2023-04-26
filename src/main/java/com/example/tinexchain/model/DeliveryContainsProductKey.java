package com.example.tinexchain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class DeliveryContainsProductKey implements Serializable{

    @Column(name = "delivery_id")
    private Long delivery_Id;

    @Column(name = "product_id")
    private Long product_Id;

    public void setDelivery_Id(Long delivery_Id) {
        this.delivery_Id = delivery_Id;
    }

    public void setProduct_Id(Long product_Id) {
        this.product_Id = product_Id;
    }
}