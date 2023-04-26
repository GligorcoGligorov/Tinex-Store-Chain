package com.example.tinexchain.repository.IzvestaiRepository;

import com.example.tinexchain.model.izestai.MesecenIGodisenProfitVoMagacin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MesecenIGodisenProfitVoMagacinRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<MesecenIGodisenProfitVoMagacin> findAll() {
        String hql = "SELECT m FROM MesecenIGodisenProfitVoMagacin m";
        TypedQuery<MesecenIGodisenProfitVoMagacin> query = entityManager.createQuery(hql, MesecenIGodisenProfitVoMagacin.class);
        return query.getResultList();
    }
}