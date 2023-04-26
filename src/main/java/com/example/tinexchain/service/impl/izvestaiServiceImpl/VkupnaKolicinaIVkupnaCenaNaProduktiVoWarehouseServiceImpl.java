package com.example.tinexchain.service.impl.izvestaiServiceImpl;

import com.example.tinexchain.model.izestai.VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse;
import com.example.tinexchain.repository.IzvestaiRepository.VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseRepository;
import com.example.tinexchain.service.izvestaiService.VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseServiceImpl implements VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseService {
    @Autowired
    private VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseRepository repository;


    @Override
    public List<VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse> listAll() {
        return repository.findAll();
    }
}
