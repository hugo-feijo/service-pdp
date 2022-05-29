package com.pdp.servicepdp.service;

import com.pdp.servicepdp.model.OrderPad;
import com.pdp.servicepdp.repository.OrderPadDAO;
import org.springframework.stereotype.Service;

@Service
public class OrderPadService {

    private final OrderPadDAO orderPadDAO;

    public OrderPadService(OrderPadDAO orderPadDAO) {
        this.orderPadDAO = orderPadDAO;
    }

    public OrderPad getOpenOrderPadByRestaurantUnityId(Integer restaurantUnityId) {
        return orderPadDAO.getOpenOrderPadByRestaurantUnityId(restaurantUnityId).stream().findFirst().orElse(null);
    }
}
