package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.OrderPad;
import com.pdp.servicepdp.service.OrderPadService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/order-pad")
public class OrderPadRest {
    private final OrderPadService orderPadService;

    public OrderPadRest(OrderPadService orderPadService) {
        this.orderPadService = orderPadService;
    }

    @GetMapping("/open")
    public OrderPad getOpenOrderPad(@RequestParam("restaurantUnityId") Integer restaurantUnityId) {
        return orderPadService.getOpenOrderPadByRestaurantUnityId(restaurantUnityId);
    }
}
