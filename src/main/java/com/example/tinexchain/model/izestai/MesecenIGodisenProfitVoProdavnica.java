package com.example.tinexchain.model.izestai;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
@Table(name = "mesecen_i_godisen_profit_vo_prodavnica")
public class MesecenIGodisenProfitVoProdavnica {
    @Id
    @Column(name = "store_name")
    private String storeName;
    @Column(name = "mesec")
    private BigInteger mesec;
    @Column(name = "godina")
    private BigInteger godina;
    @Column(name = "profit_od_produkti_vo_store")
    private double profitOdProduktiVoStore;


}