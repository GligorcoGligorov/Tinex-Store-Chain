package com.example.tinexchain.repository.viewsRepository;

import com.example.tinexchain.model.views.ListanjeProduktiOdStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListanjeProduktiOdStoreRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ListanjeProduktiOdStore> findAll() {
        String hql = "SELECT l FROM ListanjeProduktiOdStore l";
        TypedQuery<ListanjeProduktiOdStore> query = entityManager.createQuery(hql, ListanjeProduktiOdStore.class);
        return query.getResultList();
    }

//    @Query("SELECT l FROM ListanjeProduktiOdStore l WHERE l.storeId = :storeId")
    public List<ListanjeProduktiOdStore> findByStoreId(@Param("storeId") long storeId) {
        String hql ="SELECT l FROM ListanjeProduktiOdStore l WHERE l.storeId = :storeId";
        TypedQuery<ListanjeProduktiOdStore> query = entityManager.createQuery(hql, ListanjeProduktiOdStore.class);
        query.setParameter("storeId", storeId);
        return query.getResultList();
    }


}