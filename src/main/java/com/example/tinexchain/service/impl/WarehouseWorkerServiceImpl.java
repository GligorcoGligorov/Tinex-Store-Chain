package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.SaleWorker;
import com.example.tinexchain.model.WarehouseWorker;
import com.example.tinexchain.repository.SaleWorkerRepository;
import com.example.tinexchain.repository.WarehouseWorkerRepository;
import com.example.tinexchain.service.SaleWorkerService;
import com.example.tinexchain.service.WarehouseWorkerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseWorkerServiceImpl implements WarehouseWorkerService {
    private  final WarehouseWorkerRepository repository;

    public WarehouseWorkerServiceImpl(WarehouseWorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WarehouseWorker> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<WarehouseWorker> findEmployeeById(int id) {
        return repository.findById(id);
    }
}
