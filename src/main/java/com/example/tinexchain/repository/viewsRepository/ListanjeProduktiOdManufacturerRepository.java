package com.example.tinexchain.repository.viewsRepository;

import com.example.tinexchain.model.views.ListanjeProduktiOdDelivery;
import com.example.tinexchain.model.views.ListanjeProduktiOdManufacturer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListanjeProduktiOdManufacturerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ListanjeProduktiOdManufacturer> findAll() {
        String hql = "SELECT l FROM ListanjeProduktiOdManufacturer l";
        TypedQuery<ListanjeProduktiOdManufacturer> query = entityManager.createQuery(hql, ListanjeProduktiOdManufacturer.class);
        return query.getResultList();
    }

    public List<ListanjeProduktiOdManufacturer> findByManufacturerName(@Param("manufacturerName") String manufacturerName) {
        String hql ="SELECT l FROM ListanjeProduktiOdManufacturer l WHERE l.manufacturer = :manufacturerName";
        TypedQuery<ListanjeProduktiOdManufacturer> query = entityManager.createQuery(hql, ListanjeProduktiOdManufacturer.class);
        query.setParameter("manufacturerName", manufacturerName);
        return query.getResultList();
    }
}