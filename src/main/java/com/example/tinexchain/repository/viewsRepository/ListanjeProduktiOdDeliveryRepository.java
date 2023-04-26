package com.example.tinexchain.repository.viewsRepository;


import com.example.tinexchain.model.views.ListanjeProduktiOdDelivery;
import com.example.tinexchain.model.views.ListanjeProduktiOdStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListanjeProduktiOdDeliveryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ListanjeProduktiOdDelivery> findAll() {
        String hql = "SELECT l FROM ListanjeProduktiOdDelivery l";
        TypedQuery<ListanjeProduktiOdDelivery> query = entityManager.createQuery(hql, ListanjeProduktiOdDelivery.class);
        return query.getResultList();
    }

    public List<ListanjeProduktiOdDelivery> findByDeliveryId(@Param("deliveryId") long deliveryId) {
        String hql ="SELECT l FROM ListanjeProduktiOdDelivery l WHERE l.deliveryId = :deliveryId";
        TypedQuery<ListanjeProduktiOdDelivery> query = entityManager.createQuery(hql, ListanjeProduktiOdDelivery.class);
        query.setParameter("deliveryId", deliveryId);
        return query.getResultList();
    }
}