package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
public class StoreHaveProductKey implements Serializable {

    @Column(name = "store_id")
    private Long store_Id;

    @Column(name = "product_id")
    private Long product_Id;

}
