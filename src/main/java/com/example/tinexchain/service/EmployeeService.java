package com.example.tinexchain.service;

import com.example.tinexchain.model.Employee;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> listAll();
    Optional<Employee> findEmployeeById(int id);
}
