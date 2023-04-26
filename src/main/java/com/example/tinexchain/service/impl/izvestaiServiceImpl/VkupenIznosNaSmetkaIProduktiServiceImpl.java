package com.example.tinexchain.service.impl.izvestaiServiceImpl;

import com.example.tinexchain.model.izestai.VkupenIznosNaSmetkaIProdukti;
import com.example.tinexchain.repository.IzvestaiRepository.VkupenIznosNaSmetkaIProduktiRepository;
import com.example.tinexchain.service.izvestaiService.VkupenIznosNaSmetkaIProduktiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VkupenIznosNaSmetkaIProduktiServiceImpl implements VkupenIznosNaSmetkaIProduktiService {
    @Autowired
    private VkupenIznosNaSmetkaIProduktiRepository repository;
    @Override
    public List<VkupenIznosNaSmetkaIProdukti> listAll() {
        return repository.findAll();
    }
}
