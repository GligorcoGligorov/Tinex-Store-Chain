package com.example.tinexchain.service.impl;

import com.example.tinexchain.model.Employee;
import com.example.tinexchain.repository.EmployeeRepository;
import com.example.tinexchain.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private  final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        return repository.findById(id);
    }
}
