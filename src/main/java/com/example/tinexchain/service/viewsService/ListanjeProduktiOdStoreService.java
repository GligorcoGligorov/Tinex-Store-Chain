package com.example.tinexchain.service.viewsService;

import com.example.tinexchain.model.views.ListanjeProduktiOdStore;

import java.util.List;

public interface ListanjeProduktiOdStoreService {
    List<ListanjeProduktiOdStore> listAll();
     List<ListanjeProduktiOdStore> listProductsByStoreId(long storeId);
}
