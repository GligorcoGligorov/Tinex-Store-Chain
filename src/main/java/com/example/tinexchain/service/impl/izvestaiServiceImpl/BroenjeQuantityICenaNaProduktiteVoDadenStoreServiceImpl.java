package com.example.tinexchain.service.impl.izvestaiServiceImpl;

import com.example.tinexchain.model.izestai.BroenjeQuantityICenaNaProduktiteVoDadenStore;
import com.example.tinexchain.repository.IzvestaiRepository.BroenjeQuantityICenaNaProduktiteVoDadenStoreRepository;
import com.example.tinexchain.service.izvestaiService.BroenjeQuantityICenaNaProduktiteVoDadenStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroenjeQuantityICenaNaProduktiteVoDadenStoreServiceImpl implements BroenjeQuantityICenaNaProduktiteVoDadenStoreService {
    @Autowired
    private BroenjeQuantityICenaNaProduktiteVoDadenStoreRepository repository;

    @Override
    public List<BroenjeQuantityICenaNaProduktiteVoDadenStore> listAll() {
        return repository.findAll();
    }
}