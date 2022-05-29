package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.OrderPad;
import com.pdp.servicepdp.repository.OrderPadDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPadService {

    private final OrderPadDAO orderPadDAO;
    private final RestaurantTableService restaurantTableService;


    public OrderPadService(OrderPadDAO orderPadDAO, RestaurantTableService restaurantTableService) {
        this.orderPadDAO = orderPadDAO;
        this.restaurantTableService = restaurantTableService;
    }

    public OrderPad getOpenedOrderPadOrCreate(Integer restaurantUnityId, Integer tableId) {
        List<OrderPad> openedOrderPad = orderPadDAO.getOpenedOrderPadByRestaurantUnityIdAndTableId(restaurantUnityId, tableId);
        return switch (openedOrderPad.size()) {
            case 0 -> this.createOrderPad(tableId);
            case 1 -> openedOrderPad.get(0);
            default -> throw new GlobalException("More than one opened order pad", HttpStatus.BAD_REQUEST);
        };
    }

    public OrderPad createOrderPad(Integer tableId) {
        var orderPad = new OrderPad();
        orderPad.setTable(restaurantTableService.findById(tableId));
        orderPadDAO.create(orderPad);
        return orderPad;
    }
}
