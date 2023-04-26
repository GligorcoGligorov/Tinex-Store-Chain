package com.example.tinexchain.service;

import com.example.tinexchain.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WarehouseWorkerWorksAtWarehouseService {

    List<WarehouseWorker_WorksAt_Warehouse> listAll();

    Optional<LocalDate> getWorkStartsIn(WarehouseWorker warehouseWorker,Warehouse warehouse);
    Optional<LocalDate> getWorkEndsIn(WarehouseWorker warehouseWorker,Warehouse warehouse);

}
