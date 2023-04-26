package com.example.tinexchain.service.viewsService;

import com.example.tinexchain.model.views.ListanjeProduktiOdStore;
import com.example.tinexchain.model.views.ListanjeProduktiOdWarehouse;

import java.util.List;

public interface ListanjeProduktiOdWarehouseService {
    List<ListanjeProduktiOdWarehouse> listAll();
    List<ListanjeProduktiOdWarehouse> listProductsByWarehouseId(long warehouseId);

}
