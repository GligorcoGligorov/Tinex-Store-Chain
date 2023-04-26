package com.example.tinexchain.repository.viewsRepository;

import com.example.tinexchain.model.views.ListanjeProduktiOdManufacturer;
import com.example.tinexchain.model.views.ListanjeProduktiPoKategorija;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListanjeProduktiPoKategorijaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ListanjeProduktiPoKategorija> findAll() {
        String hql = "SELECT l FROM ListanjeProduktiPoKategorija l";
        TypedQuery<ListanjeProduktiPoKategorija> query = entityManager.createQuery(hql, ListanjeProduktiPoKategorija.class);
        return query.getResultList();
    }

    public List<ListanjeProduktiPoKategorija> findByCategoryName(@Param("categoryName") String categoryName) {
        String hql ="SELECT l FROM ListanjeProduktiPoKategorija l WHERE l.categoryName = :categoryName";
        TypedQuery<ListanjeProduktiPoKategorija> query = entityManager.createQuery(hql, ListanjeProduktiPoKategorija.class);
        query.setParameter("categoryName", categoryName);
        return query.getResultList();
    }
}