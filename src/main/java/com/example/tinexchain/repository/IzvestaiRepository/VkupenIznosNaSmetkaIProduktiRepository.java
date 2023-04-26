package com.example.tinexchain.repository.IzvestaiRepository;

import com.example.tinexchain.model.izestai.MesecenIGodisenProfitVoMagacin;
import com.example.tinexchain.model.izestai.VkupenIznosNaSmetkaIProdukti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class VkupenIznosNaSmetkaIProduktiRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<VkupenIznosNaSmetkaIProdukti> findAll() {
        String hql = "SELECT m FROM VkupenIznosNaSmetkaIProdukti m";
        TypedQuery<VkupenIznosNaSmetkaIProdukti> query = entityManager.createQuery(hql, VkupenIznosNaSmetkaIProdukti.class);
        return query.getResultList();
    }
}
