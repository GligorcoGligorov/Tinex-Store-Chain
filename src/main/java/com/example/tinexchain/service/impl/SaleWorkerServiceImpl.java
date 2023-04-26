package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Employee;
import com.example.tinexchain.model.SaleWorker;
import com.example.tinexchain.repository.EmployeeRepository;
import com.example.tinexchain.repository.SaleWorkerRepository;
import com.example.tinexchain.service.EmployeeService;
import com.example.tinexchain.service.SaleWorkerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleWorkerServiceImpl implements SaleWorkerService {
    private  final SaleWorkerRepository repository;

    public SaleWorkerServiceImpl(SaleWorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SaleWorker> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SaleWorker> findEmployeeById(Long id) {
        return repository.findById(id);
    }
}
