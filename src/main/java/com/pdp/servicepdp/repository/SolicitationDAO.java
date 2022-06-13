package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.Solicitation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolicitationDAO extends dao<Solicitation> {
    public List<Solicitation> findByClientId(Integer clientId) {
        String jpql = "SELECT s FROM Solicitation s INNER JOIN s.clientsSolicitation cs WHERE cs.client.id = ?1";
        return super.read(jpql, clientId);
    }
}
