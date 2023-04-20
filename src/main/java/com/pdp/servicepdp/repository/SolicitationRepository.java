package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.model.Solicitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolicitationRepository extends JpaRepository<Solicitation,Integer> {
    @Query("SELECT s FROM Solicitation s INNER JOIN s.clientsSolicitation cs WHERE cs.client.id = ?1")
    public List<Solicitation> findByClientId(Integer clientId);

    public List<Solicitation> findByOrderPadRestaurantTableRestaurantUnityIdAndDeliveredAtIsNull(Integer id);
}
