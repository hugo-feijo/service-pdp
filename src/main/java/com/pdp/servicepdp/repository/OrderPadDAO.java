package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.Dados;
import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.Client;
import com.pdp.servicepdp.model.OrderPad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

public interface OrderPadDAO extends JpaRepository<OrderPad,Integer> {
    @Query("select DISTINCT op from OrderPad op INNER JOIN op.clients c WHERE c.active = true AND op.restaurantTable.id = ?1 AND op.closedAt IS NULL")
    public List<OrderPad> getOpenedOrderPadByTableId(Integer tableId);
}
