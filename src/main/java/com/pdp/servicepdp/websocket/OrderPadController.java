package com.pdp.servicepdp.websocket;

import com.pdp.servicepdp.model.dto.ClientDTO;
import com.pdp.servicepdp.model.dto.OrderPadRequest;
import com.pdp.servicepdp.service.OrderPadService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
public class OrderPadController {
    private final OrderPadService orderPadService;

    public OrderPadController(OrderPadService orderPadService) {
        this.orderPadService = orderPadService;
    }

    @MessageMapping("/order-pad")
    public Set<ClientDTO> gettingClientActiveByOrderPad(@Payload OrderPadRequest orderPadRequest){
        return orderPadService.updateOrderPadClient(orderPadRequest.orderPadId());
    }
}
