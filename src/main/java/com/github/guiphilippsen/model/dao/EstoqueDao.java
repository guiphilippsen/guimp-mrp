package com.github.guiphilippsen.model.dao;
import com.github.guiphilippsen.model.entities.Estoque;
import com.github.guiphilippsen.model.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstoqueDao {

    public void save(Estoque estoque) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(estoque);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Estoque> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Estoque> estoque;
        try {
            estoque = em.createQuery("from Estoque", Estoque.class).getResultList();
        } finally {
            em.close();
        }
        return estoque;
    }

    public void update(Estoque estoque) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            em.getTransaction().begin();
            em.merge(estoque);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            Estoque estoque = em.find(Estoque.class, id);
            if (estoque != null) {
                em.remove(estoque);
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Estoque> searchByName(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Estoque> produtos = null;
        try {
            TypedQuery<Estoque> query = em.createQuery("FROM Estoque WHERE nome LIKE :nome", Estoque.class);
            query.setParameter("nome", "%" + nome + "%");
            produtos = query.getResultList();
        } finally {
            em.close();
        }
        return produtos;
    }

    public Estoque findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Estoque estoque = null;
        try {
            estoque = em.find(Estoque.class, id);
        } finally {
            em.close();
        }
        return estoque;
    }
}
