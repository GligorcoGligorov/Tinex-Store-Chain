package com.example.tinexchain.model.izestai;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vkupno_produkti_i_vkupnasuma_vo_store_od_delivery")
public class VkupnoProduktiIVkupnaSumaVoStoreOdDelivery {

    @Id
    private Long deliveryId;
    private int quantityProducts;
    private double sumPrice;
    private Long warehouseId;
    private String storeName;

    // getters and setters
}