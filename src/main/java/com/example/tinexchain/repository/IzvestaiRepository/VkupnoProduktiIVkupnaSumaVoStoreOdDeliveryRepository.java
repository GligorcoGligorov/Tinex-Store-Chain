package com.example.tinexchain.repository.IzvestaiRepository;

import com.example.tinexchain.model.izestai.BroenjeQuantityICenaNaProduktiteVoDadenStore;
import com.example.tinexchain.model.izestai.VkupnoProduktiIVkupnaSumaVoStoreOdDelivery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VkupnoProduktiIVkupnaSumaVoStoreOdDeliveryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<VkupnoProduktiIVkupnaSumaVoStoreOdDelivery> findAll() {
        String hql = "SELECT b FROM VkupnoProduktiIVkupnaSumaVoStoreOdDelivery b";
        TypedQuery<VkupnoProduktiIVkupnaSumaVoStoreOdDelivery> query = entityManager.createQuery(hql, VkupnoProduktiIVkupnaSumaVoStoreOdDelivery.class);
        return query.getResultList();
    }
}
