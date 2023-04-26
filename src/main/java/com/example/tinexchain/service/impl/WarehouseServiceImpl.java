package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Warehouse;
import com.example.tinexchain.repository.WarehouseRepository;
import com.example.tinexchain.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> listAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Optional<Warehouse> findWarehouseById(int id) {
        return warehouseRepository.findById(id);
    }




}
