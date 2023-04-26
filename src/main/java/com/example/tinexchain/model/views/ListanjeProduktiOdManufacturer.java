package com.example.tinexchain.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "listanje_Produkti_Od_Manufacturer")
public class ListanjeProduktiOdManufacturer {
    @Id
    private String productName;
    private String manufacturer;
    private double productPrice;

}