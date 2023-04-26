package com.example.tinexchain.service;

import com.example.tinexchain.model.Delivery;
import com.example.tinexchain.model.SaleWorker;
import com.example.tinexchain.model.Store;
import com.example.tinexchain.model.Warehouse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DeliveryService{

    List<Delivery> listAll();
    Optional<Delivery> findDeliveryById(int id);
//    void addDelivery(int deliveryId, LocalDate date, String delivery_vehicle, String driver_name, String delivery_list, Store store);
    void save(Delivery delivery);

}
