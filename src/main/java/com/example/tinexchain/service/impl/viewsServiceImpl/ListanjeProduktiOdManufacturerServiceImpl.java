package com.example.tinexchain.service.impl.viewsServiceImpl;

import com.example.tinexchain.model.views.ListanjeProduktiOdManufacturer;
import com.example.tinexchain.repository.viewsRepository.ListanjeProduktiOdManufacturerRepository;
import com.example.tinexchain.service.viewsService.ListanjeProduktiOdManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListanjeProduktiOdManufacturerServiceImpl implements ListanjeProduktiOdManufacturerService {

    @Autowired
    private ListanjeProduktiOdManufacturerRepository repository;



    @Override
    public List<ListanjeProduktiOdManufacturer> listAll() {
        return repository.findAll();
    }

    @Override
    public List<ListanjeProduktiOdManufacturer> listProductsByManufacturerId(String manufacturerName) {
        return repository.findByManufacturerName(manufacturerName);
    }
}
