package com.example.tinexchain.repository;

import com.example.tinexchain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseWorkerWorksAtWarehouseRepository extends JpaRepository<WarehouseWorker_WorksAt_Warehouse,WarehouseWorker_WorksAt_WarehouseKey> {

        WarehouseWorker_WorksAt_Warehouse findByWarehouseWorkerAndWarehouse(WarehouseWorker warehouseWorker,Warehouse warehouse);
}
