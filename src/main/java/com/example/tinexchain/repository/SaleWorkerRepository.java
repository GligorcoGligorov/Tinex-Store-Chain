package com.example.tinexchain.repository;

import com.example.tinexchain.model.Employee;
import com.example.tinexchain.model.SaleWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleWorkerRepository extends JpaRepository<SaleWorker,Long> {
}
