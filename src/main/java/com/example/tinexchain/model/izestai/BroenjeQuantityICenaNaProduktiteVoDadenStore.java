package com.example.tinexchain.model.izestai;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "broenje_quantity_i_cena_na_produktite_vo_daden_store")
public class BroenjeQuantityICenaNaProduktiteVoDadenStore {
    @Id
    private String storeName;
    private String storeCity;
    private int quantityProducts;
    private double sumProductPrice;

}