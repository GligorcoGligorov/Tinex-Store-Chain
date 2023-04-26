package com.example.tinexchain.service;

import com.example.tinexchain.model.Employee;
import com.example.tinexchain.model.SaleWorker;

import java.util.List;
import java.util.Optional;

public interface SaleWorkerService {
    List<SaleWorker> listAll();
    Optional<SaleWorker> findEmployeeById(Long id);
}
