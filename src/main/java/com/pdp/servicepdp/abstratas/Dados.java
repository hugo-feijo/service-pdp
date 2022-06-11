package com.pdp.servicepdp.abstratas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class Dados {

    private static EntityManager manager = null;
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("servicePDPPU");

    public static EntityManager getEntityManager() {

        if (manager == null) {

            manager = factory.createEntityManager();
        }
        return manager;
    }
}
