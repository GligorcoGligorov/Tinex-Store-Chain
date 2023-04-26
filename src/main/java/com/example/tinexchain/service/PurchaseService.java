package com.example.tinexchain.service;

import com.example.tinexchain.model.Purchase;
import com.example.tinexchain.model.SaleWorker;
import com.example.tinexchain.model.Store;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PurchaseService {

    List<Purchase> listAll();
    Optional<Purchase> findById(int id);
    void addPurchase(int purchaseId, LocalDate date, SaleWorker employeeId, Store storeId);
}
