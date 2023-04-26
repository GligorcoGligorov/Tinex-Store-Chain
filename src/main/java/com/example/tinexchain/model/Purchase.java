package com.example.tinexchain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Purchase {

    @Id
    private long purchase_id;

    @Column(columnDefinition = "TIMESTAMP(6)")
    private LocalDate date_and_time;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private SaleWorker saleWorker;


}
