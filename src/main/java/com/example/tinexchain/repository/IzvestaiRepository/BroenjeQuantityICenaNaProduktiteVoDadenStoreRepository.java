package com.example.tinexchain.repository.IzvestaiRepository;

import com.example.tinexchain.model.izestai.BroenjeQuantityICenaNaProduktiteVoDadenStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BroenjeQuantityICenaNaProduktiteVoDadenStoreRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<BroenjeQuantityICenaNaProduktiteVoDadenStore> findAll() {
        String hql = "SELECT b FROM BroenjeQuantityICenaNaProduktiteVoDadenStore b";
        TypedQuery<BroenjeQuantityICenaNaProduktiteVoDadenStore> query = entityManager.createQuery(hql, BroenjeQuantityICenaNaProduktiteVoDadenStore.class);
        return query.getResultList();
    }
}