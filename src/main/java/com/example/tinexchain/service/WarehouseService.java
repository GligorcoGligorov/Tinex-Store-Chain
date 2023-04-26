package com.example.tinexchain.service;

import com.example.tinexchain.model.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {

    List<Warehouse> listAll();
    Optional<Warehouse> findWarehouseById(int id);
}
