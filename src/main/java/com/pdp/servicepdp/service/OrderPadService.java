package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.OrderPad;
import com.pdp.servicepdp.model.dto.OrderPadDTO;
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

    public OrderPadDTO getOpenedOrderPadOrCreate(Integer tableId) {
        List<OrderPad> openedOrderPad = orderPadDAO.getOpenedOrderPadByTableId(tableId);
        return switch (openedOrderPad.size()) {
            case 0 -> new OrderPadDTO(this.createOrderPad(tableId));
            case 1 -> new OrderPadDTO(openedOrderPad.get(0));
            default -> throw new GlobalException("More than one opened order pad", HttpStatus.BAD_REQUEST);
        };
    }

    public OrderPad createOrderPad(Integer tableId) {
        var orderPad = new OrderPad();
        orderPad.setRestaurantTable(restaurantTableService.findById(tableId));
        orderPadDAO.save(orderPad);
        return orderPad;
    }

    public OrderPad findById(Integer orderPadId) {
        var orderPad = orderPadDAO.findById(orderPadId);
        if (orderPad.isEmpty())
            throw new GlobalException("OrderPad not found", HttpStatus.NOT_FOUND);
        return orderPad.get();
    }
}
