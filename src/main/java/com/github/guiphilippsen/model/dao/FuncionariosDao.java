package com.github.guiphilippsen.model.dao;

import com.github.guiphilippsen.model.entities.Funcionarios;
import com.github.guiphilippsen.model.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionariosDao {

    public void addFuncionario(Funcionarios funcionario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Funcionarios getFuncionarioById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Funcionarios.class, id);
        } finally {
            em.close();
        }
    }

    public void updateFuncionario(Funcionarios funcionario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteFuncionario(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Funcionarios funcionario = em.find(Funcionarios.class, id);
            if (funcionario != null) {
                em.getTransaction().begin();
                em.remove(funcionario);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    public List<Funcionarios> getAllFuncionarios() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Funcionarios> query = em.createQuery("SELECT f FROM Funcionarios f", Funcionarios.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Funcionarios> searchByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Funcionarios> query = em.createQuery("SELECT f FROM Funcionarios f WHERE f.nome LIKE :nome", Funcionarios.class);
            query.setParameter("nome", "%" + name + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
