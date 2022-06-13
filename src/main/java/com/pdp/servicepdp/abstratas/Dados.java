package com.pdp.servicepdp.abstratas;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
@Component
abstract public class Dados {



    private static EntityManager manager = null;
    public static EntityManager getEntityManager() {

        if (manager == null) {
            var properties = new HashMap<String, String>();
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("servicePDPPU", properties);
            manager = factory.createEntityManager();
        }
        return manager;
    }
}
