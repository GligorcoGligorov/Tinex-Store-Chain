package com.example.tinexchain.service.impl.viewsServiceImpl;

import com.example.tinexchain.model.views.ListanjeProduktiOdWarehouse;
import com.example.tinexchain.repository.viewsRepository.ListanjeProduktiOdWarehouseRepository;
import com.example.tinexchain.service.viewsService.ListanjeProduktiOdWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListanjeProduktiOdWarehouseServiceImpl implements ListanjeProduktiOdWarehouseService {
    @Autowired
    private ListanjeProduktiOdWarehouseRepository repository;


    @Override
    public List<ListanjeProduktiOdWarehouse> listAll() {
        return repository.findAll();
    }

    @Override
    public List<ListanjeProduktiOdWarehouse> listProductsByWarehouseId(long warehouseId) {
        return repository.findByWarehouseId(warehouseId);
    }
}