package com.github.guiphilippsen.model.dao;

import com.github.guiphilippsen.model.entities.Auth;
import com.github.guiphilippsen.model.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthDao {
    public List<Auth> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Auth> auth;
        try {
            auth = em.createQuery("from Funcionarios", Auth.class).getResultList();
        } finally {
            em.close();
        }
        return auth;
    }
}
