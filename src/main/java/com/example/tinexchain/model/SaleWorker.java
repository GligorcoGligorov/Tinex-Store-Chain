package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "sale_worker")
public class SaleWorker extends Employee{

    @OneToMany(mappedBy = "saleWorker")
    Set<Purchase> purchaseSet;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public SaleWorker(Long employee_Id, String employee_name, String employee_surname, Set<Purchase> purchaseSet) {
        super(employee_Id, employee_name, employee_surname);
        this.purchaseSet = purchaseSet;
    }

    public SaleWorker(Long employee_Id, String employee_name, String employee_surname) {
        super(employee_Id, employee_name, employee_surname);
    }

    public SaleWorker(Set<Purchase> purchaseSet) {
        this.purchaseSet = purchaseSet;
    }

    @Override
    public String toString() {
        return "SALE WORKER:" + super.toString();
    }

    public SaleWorker() {

    }



}
