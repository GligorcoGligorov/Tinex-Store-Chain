package com.example.tinexchain.service;

import com.example.tinexchain.model.Employee;
import com.example.tinexchain.model.Warehouse;
import com.example.tinexchain.model.WarehouseWorker;

import java.util.List;
import java.util.Optional;

public interface WarehouseWorkerService {
    List<WarehouseWorker> listAll();
    Optional<WarehouseWorker> findEmployeeById(int id);
}
