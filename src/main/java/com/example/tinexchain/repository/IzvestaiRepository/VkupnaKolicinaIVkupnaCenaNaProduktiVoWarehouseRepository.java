package com.example.tinexchain.repository.IzvestaiRepository;

import com.example.tinexchain.model.izestai.VkupenIznosNaSmetkaIProdukti;
import com.example.tinexchain.model.izestai.VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse> findAll() {
        String hql = "SELECT m FROM VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse m";
        TypedQuery<VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse> query = entityManager.createQuery(hql, VkupnaKolicinaIVkupnaCenaNaProduktiVoWarehouse.class);
        return query.getResultList();
    }
}
