package com.example.tinexchain.model.izestai;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vkupna_kolicina_i_vkupna_cena_na_produkti_vo_warehouse")
public class VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse {

    @Id
    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "quantity_products")
    private Long quantityProducts;

    @Column(name = "sum_products_price")
    private Double sumProductsPrice;

    // getters and setters
}