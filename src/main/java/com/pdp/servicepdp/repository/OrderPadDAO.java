package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.OrderPad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderPadDAO extends dao<OrderPad> {
    public List<OrderPad> getOpenedOrderPadByRestaurantUnityIdAndTableId(Integer restaurantUnityId, Integer tableId) {
        String jpql="select op from OrderPad op WHERE op.table.id = ?1 AND op.table.restaurantUnity.id = ?2 AND op.closedAt IS NULL";
        return super.read(jpql, tableId, restaurantUnityId);
    }
}
