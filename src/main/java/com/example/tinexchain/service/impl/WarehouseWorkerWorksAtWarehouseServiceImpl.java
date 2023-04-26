package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Product;
import com.example.tinexchain.model.Warehouse;
import com.example.tinexchain.model.WarehouseWorker;
import com.example.tinexchain.model.WarehouseWorker_WorksAt_Warehouse;
import com.example.tinexchain.repository.WarehouseWorkerWorksAtWarehouseRepository;
import com.example.tinexchain.service.WarehouseWorkerWorksAtWarehouseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseWorkerWorksAtWarehouseServiceImpl implements WarehouseWorkerWorksAtWarehouseService {

    private final WarehouseWorkerWorksAtWarehouseRepository warehouseRepository;

    public WarehouseWorkerWorksAtWarehouseServiceImpl(WarehouseWorkerWorksAtWarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<WarehouseWorker_WorksAt_Warehouse> listAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Optional<LocalDate> getWorkStartsIn(WarehouseWorker warehouseWorker, Warehouse warehouse) {
        return Optional.of(warehouseRepository.findByWarehouseWorkerAndWarehouse(warehouseWorker,warehouse).getWork_starts_in());
    }

    @Override
    public Optional<LocalDate> getWorkEndsIn(WarehouseWorker warehouseWorker, Warehouse warehouse) {
        return Optional.of(warehouseRepository.findByWarehouseWorkerAndWarehouse(warehouseWorker,warehouse).getWork_ends_in());
    }


}
