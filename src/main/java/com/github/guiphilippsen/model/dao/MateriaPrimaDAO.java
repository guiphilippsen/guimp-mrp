package com.github.guiphilippsen.model.dao;

import com.github.guiphilippsen.model.entities.MateriaPrima;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MateriaPrimaDAO {

    private EntityManager entityManager;

    public MateriaPrimaDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laUnidad");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<MateriaPrima> getAllMateriaPrima() {
        TypedQuery<MateriaPrima> query = entityManager.createQuery("SELECT mp FROM estoquemp mp", MateriaPrima.class);
        return query.getResultList();
    }

    // Adicione métodos para adicionar, remover e editar materiais conforme necessário

    public void close() {
        entityManager.close();
    }
}
