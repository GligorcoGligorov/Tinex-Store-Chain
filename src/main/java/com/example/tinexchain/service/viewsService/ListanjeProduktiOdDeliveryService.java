package com.example.tinexchain.service.viewsService;

import com.example.tinexchain.model.views.ListanjeProduktiOdDelivery;
import com.example.tinexchain.model.views.ListanjeProduktiOdStore;

import java.util.List;

public interface ListanjeProduktiOdDeliveryService {
    List<ListanjeProduktiOdDelivery> listAll();
    List<ListanjeProduktiOdDelivery> listProductsByDeliveryId(long deliveryId);

}
