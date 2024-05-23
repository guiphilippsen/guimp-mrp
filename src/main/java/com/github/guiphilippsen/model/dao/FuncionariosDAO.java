package com.github.guiphilippsen.model.dao;

import com.github.guiphilippsen.model.entities.Funcionarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionariosDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("laUnidad");
    private static final Logger LOGGER = Logger.getLogger(FuncionariosDAO.class.getName());

    public Funcionarios findUserByUsernameAndPassword(int id, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            LOGGER.log(Level.INFO, "Procurando usuário com id: {0} e password: {1}", new Object[]{id, password});
            TypedQuery<Funcionarios> query = em.createQuery(
                    "SELECT f FROM Funcionarios f WHERE f.id = :id AND f.password = :password",
                    Funcionarios.class
            );
            query.setParameter("id", id);
            query.setParameter("password", password);
            Funcionarios result = query.getSingleResult();
            LOGGER.log(Level.INFO, "Usuário encontrado: {0}", result);
            return result;
        } catch (NoResultException e) {
            LOGGER.log(Level.WARNING, "Nenhum usuário encontrado para id: {0} e password: {1}", new Object[]{id, password});
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar usuário", e);
            return null;
        } finally {
            em.close();
        }
    }
}
