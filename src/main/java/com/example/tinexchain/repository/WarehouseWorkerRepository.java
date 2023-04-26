package com.example.tinexchain.repository;

import com.example.tinexchain.model.Employee;
import com.example.tinexchain.model.WarehouseWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseWorkerRepository extends JpaRepository<WarehouseWorker,Integer> {
}
