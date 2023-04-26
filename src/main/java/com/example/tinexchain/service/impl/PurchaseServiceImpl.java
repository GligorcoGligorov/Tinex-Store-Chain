package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Purchase;
import com.example.tinexchain.model.SaleWorker;
import com.example.tinexchain.model.Store;
import com.example.tinexchain.model.Warehouse;
import com.example.tinexchain.repository.PurchaseRepository;
import com.example.tinexchain.service.PurchaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<Purchase> listAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<Purchase> findById(int id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public void addPurchase(int purchaseId, LocalDate date, SaleWorker employeeId, Store storeId) {
        Purchase purchase = new Purchase();
        purchase.setPurchase_id(purchaseId);
        purchase.setDate_and_time(date);
        purchase.setSaleWorker(employeeId);
        purchase.setStore(storeId);
        purchaseRepository.save(purchase);
    }

}
