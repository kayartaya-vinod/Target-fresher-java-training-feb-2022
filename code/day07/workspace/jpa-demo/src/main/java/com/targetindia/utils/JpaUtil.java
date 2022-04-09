package com.targetindia.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil {
    private JpaUtil(){}

    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TARGET_PU");
        return emf.createEntityManager(); // creates a new DB connection; must be closed ASAP
    }
}
