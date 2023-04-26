package com.example.tinexchain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Delivery {

    @Id
    private long delivery_Id;

    @Column(columnDefinition = "TIMESTAMP(6)")
    private LocalDate delivery_Date_And_Time;

    private String delivery_vehicle;
    private String driver_name;
    private String delivery_list;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToMany(mappedBy = "deliveryList")
    private List<Warehouse> warehouseList;

    @OneToMany(mappedBy = "delivery")
    Set<DeliveryContainsProduct> quantityDelivery;

    public Delivery(long delivery_Id, LocalDate delivery_Date_And_Time, String vehicle, String driver, Store store) {
        this.delivery_Id = delivery_Id;
        this.delivery_Date_And_Time = delivery_Date_And_Time;
        this.delivery_vehicle = vehicle;
        this.driver_name = driver;
        this.store = store;
    }

    public Delivery(long delivery_Id, LocalDate delivery_Date_And_Time, String delivery_vehicle, String driver_name, Store store, List<Warehouse> warehouseList) {
        this.delivery_Id = delivery_Id;
        this.delivery_Date_And_Time = delivery_Date_And_Time;
        this.delivery_vehicle = delivery_vehicle;
        this.driver_name = driver_name;
        this.store = store;
        this.warehouseList = warehouseList;
    }

    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public Delivery() {
        
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "delivery_Id=" + delivery_Id +
                ", delivery_Date_And_Time=" + delivery_Date_And_Time +
                ", delivery_vehicle='" + delivery_vehicle + '\'' +
                ", driver_name='" + driver_name + '\'' +
                ", store=" + store +
                ", warehouseList=" + warehouseList +
                '}';
    }
}
