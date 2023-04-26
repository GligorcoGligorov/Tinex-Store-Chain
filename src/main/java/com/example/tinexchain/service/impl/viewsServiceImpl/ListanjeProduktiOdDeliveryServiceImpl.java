package com.example.tinexchain.service.impl.viewsServiceImpl;

import com.example.tinexchain.model.views.ListanjeProduktiOdDelivery;
import com.example.tinexchain.repository.viewsRepository.ListanjeProduktiOdDeliveryRepository;
import com.example.tinexchain.service.viewsService.ListanjeProduktiOdDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListanjeProduktiOdDeliveryServiceImpl implements ListanjeProduktiOdDeliveryService {
    @Autowired
    private ListanjeProduktiOdDeliveryRepository repository;


    @Override
    public List<ListanjeProduktiOdDelivery> listAll() {
        return repository.findAll();
    }

    @Override
    public List<ListanjeProduktiOdDelivery> listProductsByDeliveryId(long deliveryId) {
        return repository.findByDeliveryId(deliveryId);
    }
}