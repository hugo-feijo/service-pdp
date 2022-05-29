package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.OrderPad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderPadDAO extends dao<OrderPad> {
    public List<OrderPad> getOpenedOrderPadByTableId(Integer tableId) {
        String jpql="select op from OrderPad op WHERE op.restaurantTable.id = ?1 AND op.closedAt IS NULL";
        return super.read(jpql, tableId);
    }
}
