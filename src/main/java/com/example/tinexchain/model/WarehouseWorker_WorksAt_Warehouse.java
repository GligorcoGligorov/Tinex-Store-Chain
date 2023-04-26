package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "works_at")
public class WarehouseWorker_WorksAt_Warehouse {

    @Id
    WarehouseWorker_WorksAt_WarehouseKey warehouseWorker_worksAt_warehouseKey;

    @ManyToOne
    @MapsId("warehouse_Id")
    @JoinColumn(name = "warehouse_id")
    Warehouse warehouse;

    @ManyToOne
    @MapsId("employee_Id")
    @JoinColumn(name = "employee_id")
    WarehouseWorker warehouseWorker;


    @Column(columnDefinition = "TIMESTAMP(6)",name = "work_starts_in")
    private LocalDate work_starts_in;

    @Column(columnDefinition = "TIMESTAMP(6)",name = "work_ends_in")
    private LocalDate work_ends_in;
}
