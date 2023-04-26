package com.example.tinexchain.service.impl.izvestaiServiceImpl;

import com.example.tinexchain.model.izestai.MesecenIGodisenProfitVoProdavnica;
import com.example.tinexchain.repository.IzvestaiRepository.MesecenIGodisenProfitVoProdavnicaRepository;
import com.example.tinexchain.service.izvestaiService.MesecenIGodisenProfitVoProdavnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesecenIGodisenProfitVoProdavnicaServiceImpl implements MesecenIGodisenProfitVoProdavnicaService {
    @Autowired
    private MesecenIGodisenProfitVoProdavnicaRepository repository;

    @Override
    public List<MesecenIGodisenProfitVoProdavnica> listAll() {
        return repository.findAll();
    }
}
