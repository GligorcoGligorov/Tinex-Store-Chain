package com.example.tinexchain.service.viewsService;

import com.example.tinexchain.model.views.ListanjeProduktiOdDelivery;
import com.example.tinexchain.model.views.ListanjeProduktiOdManufacturer;
import com.example.tinexchain.model.views.ListanjeProduktiOdStore;

import java.util.List;

public interface ListanjeProduktiOdManufacturerService {
    List<ListanjeProduktiOdManufacturer> listAll();
    List<ListanjeProduktiOdManufacturer> listProductsByManufacturerId(String manufacturerName);


}
