package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.dto.OrderPadDTO;
import com.pdp.servicepdp.service.OrderPadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/order-pad")
public class OrderPadRest {
    private final OrderPadService orderPadService;

    public OrderPadRest(OrderPadService orderPadService) {
        this.orderPadService = orderPadService;
    }

    @PostMapping("/open")
    public OrderPadDTO createIfNotExist(@RequestParam("tableId") Integer tableId) {
        return orderPadService.getOpenedOrderPadOrCreate(tableId);
    }
}
