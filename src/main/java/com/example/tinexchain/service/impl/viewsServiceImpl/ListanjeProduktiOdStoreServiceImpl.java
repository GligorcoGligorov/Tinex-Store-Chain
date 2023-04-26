package com.example.tinexchain.service.impl.viewsServiceImpl;

import com.example.tinexchain.model.views.ListanjeProduktiOdStore;
import com.example.tinexchain.repository.viewsRepository.ListanjeProduktiOdStoreRepository;
import com.example.tinexchain.service.viewsService.ListanjeProduktiOdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListanjeProduktiOdStoreServiceImpl implements ListanjeProduktiOdStoreService {
    @Autowired
    private ListanjeProduktiOdStoreRepository repository;


    @Override
    public List<ListanjeProduktiOdStore> listAll() {
        return repository.findAll();
    }

    @Override
    public List<ListanjeProduktiOdStore> listProductsByStoreId(long storeId) {
        return repository.findByStoreId(storeId);
    }
}