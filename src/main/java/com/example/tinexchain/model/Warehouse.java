package com.example.tinexchain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Warehouse {

    @Id
    private long warehouse_Id;

    private String warehouse_address;

    @ManyToMany
    @JoinTable(
            name = "warehouse_sends",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "delivery_id"))
    private List<Delivery> deliveryList;

    @OneToMany(mappedBy = "warehouse")
    Set<WarehouseHaveProduct> quantityWarehouse;

    public Warehouse(long warehouse_Id, String warehouse_address) {
        this.warehouse_Id = warehouse_Id;
        this.warehouse_address = warehouse_address;
    }

    public Warehouse() {
        
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouse_Id=" + warehouse_Id +
                ", warehouse_address='" + warehouse_address + '\'' +
                '}';
    }
}
