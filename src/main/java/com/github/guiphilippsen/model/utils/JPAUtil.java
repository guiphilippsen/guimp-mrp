package com.github.guiphilippsen.model.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("laUnidad");
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }
}
