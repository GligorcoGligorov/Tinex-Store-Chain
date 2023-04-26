package com.example.tinexchain.model.izestai;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "vkupen_iznos_na_smetka_i_produkti")
public class VkupenIznosNaSmetkaIProdukti {

    @Id
    @Column(name = "purchase_id")
    private Long purchaseId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "vkupen_iznos_na_smetka")
    private Double vkupenIznosNaSmetka;

    @Column(name = "vidovi_produkti")
    private Long vidoviProdukti;

    @Column(name = "produkti")
    private Long produkti;

}