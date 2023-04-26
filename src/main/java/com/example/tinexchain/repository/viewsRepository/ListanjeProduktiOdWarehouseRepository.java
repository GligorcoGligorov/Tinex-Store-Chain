package com.example.tinexchain.repository.viewsRepository;

import com.example.tinexchain.model.views.ListanjeProduktiOdStore;
import com.example.tinexchain.model.views.ListanjeProduktiOdWarehouse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListanjeProduktiOdWarehouseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ListanjeProduktiOdWarehouse> findAll() {
        String hql = "SELECT l FROM ListanjeProduktiOdWarehouse l";
        TypedQuery<ListanjeProduktiOdWarehouse> query = entityManager.createQuery(hql, ListanjeProduktiOdWarehouse.class);
        return query.getResultList();
    }

    public List<ListanjeProduktiOdWarehouse> findByWarehouseId(@Param("warehouseId") long warehouseId) {
        String hql ="SELECT l FROM ListanjeProduktiOdWarehouse l WHERE l.warehouseId = :warehouseId";
        TypedQuery<ListanjeProduktiOdWarehouse> query = entityManager.createQuery(hql, ListanjeProduktiOdWarehouse.class);
        query.setParameter("warehouseId", warehouseId);
        return query.getResultList();
    }
}