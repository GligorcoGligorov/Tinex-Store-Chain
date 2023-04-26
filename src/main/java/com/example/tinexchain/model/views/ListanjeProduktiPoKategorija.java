package com.example.tinexchain.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "listanje_Produkti_po_Kategorija")
public class ListanjeProduktiPoKategorija {
    @Id
    private String productName;
    private double productPrice;
    private String manufacturer;
    private String categoryName;

}