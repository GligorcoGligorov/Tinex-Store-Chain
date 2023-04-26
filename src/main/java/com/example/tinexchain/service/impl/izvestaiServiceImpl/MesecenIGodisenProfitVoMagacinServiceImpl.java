package com.example.tinexchain.service.impl.izvestaiServiceImpl;

import com.example.tinexchain.model.izestai.MesecenIGodisenProfitVoMagacin;
import com.example.tinexchain.repository.IzvestaiRepository.MesecenIGodisenProfitVoMagacinRepository;
import com.example.tinexchain.service.izvestaiService.MesecenIGodisenProfitVoMagacinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesecenIGodisenProfitVoMagacinServiceImpl implements MesecenIGodisenProfitVoMagacinService {

    @Autowired
    private final MesecenIGodisenProfitVoMagacinRepository mesecenIGodisenProfitVoMagacinRepository;

    public MesecenIGodisenProfitVoMagacinServiceImpl(MesecenIGodisenProfitVoMagacinRepository mesecenIGodisenProfitVoMagacinRepository) {
        this.mesecenIGodisenProfitVoMagacinRepository = mesecenIGodisenProfitVoMagacinRepository;
    }

    @Override
    public List<MesecenIGodisenProfitVoMagacin> listAll() {
        return mesecenIGodisenProfitVoMagacinRepository.findAll();
    }
}
