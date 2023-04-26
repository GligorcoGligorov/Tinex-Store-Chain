package com.example.tinexchain.repository.IzvestaiRepository;

import com.example.tinexchain.model.izestai.MesecenIGodisenProfitVoProdavnica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MesecenIGodisenProfitVoProdavnicaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<MesecenIGodisenProfitVoProdavnica> findAll() {
        String jpql = "SELECT v FROM MesecenIGodisenProfitVoProdavnica v";
        TypedQuery<MesecenIGodisenProfitVoProdavnica> query = entityManager.createQuery(jpql, MesecenIGodisenProfitVoProdavnica.class);
        return query.getResultList();
    }
}
