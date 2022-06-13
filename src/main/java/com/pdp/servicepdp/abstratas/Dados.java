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
            properties.put("javax.persistence.jdbc.url", DbProperties.DATABASE_URL);
            properties.put("javax.persistence.jdbc.user", DbProperties.DATABASE_USER);
            properties.put("javax.persistence.jdbc.password", DbProperties.DATABASE_PASSWORD);
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("servicePDPPU", properties);
            manager = factory.createEntityManager();
        }
        return manager;
    }
}
