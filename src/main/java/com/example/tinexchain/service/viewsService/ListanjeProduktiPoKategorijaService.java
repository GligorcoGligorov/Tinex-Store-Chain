package com.example.tinexchain.service.viewsService;

import com.example.tinexchain.model.views.ListanjeProduktiOdStore;
import com.example.tinexchain.model.views.ListanjeProduktiPoKategorija;

import java.util.List;

public interface ListanjeProduktiPoKategorijaService {
    List<ListanjeProduktiPoKategorija> listAll();
    List<ListanjeProduktiPoKategorija> listProductsByCategoryId(String categoryName);

}
