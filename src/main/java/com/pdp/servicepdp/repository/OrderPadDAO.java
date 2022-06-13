package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.model.OrderPad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderPadDAO extends JpaRepository<OrderPad,Integer> {
    @Query("select DISTINCT op from OrderPad op WHERE op.restaurantTable.id = ?1 AND op.closedAt IS NULL")
    public List<OrderPad> getOpenedOrderPadByTableId(Integer tableId);
}
