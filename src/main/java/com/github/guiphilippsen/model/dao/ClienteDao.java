package com.github.guiphilippsen.model.dao;
import com.github.guiphilippsen.model.entities.Cliente;
import com.github.guiphilippsen.model.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDao {

    public void save(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(cliente);
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

    public List<Cliente> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Cliente> cliente;
        try {
            cliente = em.createQuery("from Cliente", Cliente.class).getResultList();
        }finally {
            em.close();
        }
        return cliente;
    }

    public void update(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
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
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null){
                em.remove(cliente);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public List<Cliente> searchByName(String nome){
        EntityManager em = JPAUtil.getEntityManager();
        List<Cliente> cliente = null;
        try {
            TypedQuery<Cliente> query = em.createQuery("FROM Cliente WHERE nome LIKE :nome", Cliente.class);
            query.setParameter("nome", "%" + nome + "%");
            cliente = query.getResultList();
        } finally {
            em.close();
        }
        return cliente;
    }

    public Cliente findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
        } finally {
            em.close();
        }
        return cliente;
    }
}
