package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Delivery;
import com.example.tinexchain.model.Store;
import com.example.tinexchain.model.Warehouse;
import com.example.tinexchain.repository.DeliveryRepository;
import com.example.tinexchain.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> listAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<Delivery> findDeliveryById(int id) {
        return deliveryRepository.findById(id);
    }

//    @Override
//    public void addDelivery(int deliveryId, LocalDate date, String delivery_vehicle, String driver_name, String delivery_list, Store store) {
//        Delivery delivery = new Delivery();
//        delivery.setDelivery_Id(deliveryId);
//        delivery.setDelivery_vehicle(delivery_vehicle);
//        delivery.setDelivery_Date_And_Time(date);
//        delivery.setStore(store);
//        delivery.setDriver_name(driver_name);
//        delivery.setDelivery_list(delivery_list);
//
//        System.out.println(delivery);
//        deliveryRepository.save(delivery);
//    }

    @Override
    public void save(Delivery delivery) {
        delivery.setDelivery_list(delivery.getStore().getStore_City());
        deliveryRepository.save(delivery);

    }
}
