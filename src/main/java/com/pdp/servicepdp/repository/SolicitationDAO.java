package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.Solicitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SolicitationDAO extends JpaRepository<Solicitation,Integer> {
    @Query("SELECT s FROM Solicitation s INNER JOIN s.clientsSolicitation cs WHERE cs.client.id = ?1")
    public List<Solicitation> findByClientId(Integer clientId);
//    {
//        String jpql = "SELECT s FROM Solicitation s INNER JOIN s.clientsSolicitation cs WHERE cs.client.id = ?1";
//        return super.read(jpql, clientId);
//    }
}
