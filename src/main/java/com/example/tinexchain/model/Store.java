package com.example.tinexchain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Store {

    @Id
    private long store_Id;

    private String store_Name;
    private String store_City;
    private String store_Street;

    @OneToMany(mappedBy = "store")
    Set<StoreHaveProduct> quantity;

    @OneToMany(mappedBy = "store")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "store")
    private List<Purchase> purchaseList;

    @OneToMany(mappedBy = "store")
    private List<SaleWorker> saleWorkerList;

    public Store(int store_Id, String store_Name, String store_City, String store_Street) {
        this.store_Id = store_Id;
        this.store_Name = store_Name;
        this.store_City = store_City;
        this.store_Street = store_Street;
    }

    public Store() {

    }

    @Override
    public String toString() {
        return "Store{" +
                "store_Id=" + store_Id +
                ", store_Name='" + store_Name + '\'' +
                ", store_City='" + store_City + '\'' +
                ", store_Street='" + store_Street + '\'' +
                '}';
    }
}
