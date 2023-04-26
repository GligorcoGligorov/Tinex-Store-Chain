package com.example.tinexchain.service.impl.izvestaiServiceImpl;

import com.example.tinexchain.model.izestai.VkupnoProduktiIVkupnaSumaVoStoreOdDelivery;
import com.example.tinexchain.repository.IzvestaiRepository.VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryRepository;
import com.example.tinexchain.service.izvestaiService.VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryServiceImpl implements VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryService {

    @Autowired
    private VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryRepository repository;


    @Override
    public List<VkupnoProduktiIVkupnaSumaVoStoreOdDelivery> listAll() {
        return repository.findAll();
    }
}
