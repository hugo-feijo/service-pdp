package com.pdp.servicepdp.abstratas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class Dados {

    private static EntityManager manager = null;

    public static EntityManager getEntityManager() {

        if (manager == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("servicePDPPU");

            manager = factory.createEntityManager();
        }
        return manager;
    }
}
