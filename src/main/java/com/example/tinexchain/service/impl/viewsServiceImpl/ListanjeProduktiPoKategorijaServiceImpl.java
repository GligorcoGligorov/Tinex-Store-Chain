package com.example.tinexchain.service.impl.viewsServiceImpl;

import com.example.tinexchain.model.views.ListanjeProduktiPoKategorija;
import com.example.tinexchain.repository.viewsRepository.ListanjeProduktiPoKategorijaRepository;
import com.example.tinexchain.service.viewsService.ListanjeProduktiPoKategorijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListanjeProduktiPoKategorijaServiceImpl implements ListanjeProduktiPoKategorijaService {
    @Autowired
    private ListanjeProduktiPoKategorijaRepository repository;

    @Override
    public List<ListanjeProduktiPoKategorija> listAll() {
        return repository.findAll();
    }

    @Override
    public List<ListanjeProduktiPoKategorija> listProductsByCategoryId(String categoryName) {
        return repository.findByCategoryName(categoryName);
    }
}