package com.example.tinexchain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Product {

    @Id
    private long product_ID;

    private String product_Name;
    private String manufacturer;
    private float product_Price;


    @OneToMany(mappedBy = "product")
    Set<StoreHaveProduct> quantityStore;

    @OneToMany(mappedBy = "product")
    Set<DeliveryContainsProduct> quantityDelivery;

    @OneToMany(mappedBy = "product")
    Set<WarehouseHaveProduct> quantityWarehouse;

    public Product(int product_ID, String product_Name, String manufacturer, float product_Price) {
        this.product_ID = product_ID;
        this.product_Name = product_Name;
        this.manufacturer = manufacturer;
        this.product_Price = product_Price;
    }

    @ManyToMany(mappedBy = "productList")
    @JsonIgnoreProperties(value = "productList")
    private List<Category> categoryList;

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "product_ID=" + product_ID +
                ", product_Name='" + product_Name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", product_Price=" + product_Price +
                ", categoryList=" + categoryList +
                '}';
    }
}
