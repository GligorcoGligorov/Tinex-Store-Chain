package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "warehouse_worker")
public class WarehouseWorker extends Employee {

    public WarehouseWorker(Long employee_Id, String employee_name, String employee_surname) {
        super(employee_Id, employee_name, employee_surname);
    }

    @Override
    public String toString() {
        return "WAREHOUSE WORKER:" + super.toString();
    }

    public WarehouseWorker() {

    }


}