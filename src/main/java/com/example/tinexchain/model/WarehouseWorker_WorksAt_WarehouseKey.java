package com.example.tinexchain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class WarehouseWorker_WorksAt_WarehouseKey implements Serializable {

    @Column(name = "warehouse_id")
    private Long warehouse_Id;

    @Column(name = "employee_id")
    private Long employee_Id;
}
