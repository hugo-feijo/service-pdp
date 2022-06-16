package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.dto.OrderPadDTO;
import com.pdp.servicepdp.service.OrderPadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/v1/api/order-pad")
public class OrderPadRest {
    private final OrderPadService orderPadService;

    public OrderPadRest(OrderPadService orderPadService) {
        this.orderPadService = orderPadService;
    }

    @PostMapping("/open")
    public OrderPadDTO createIfNotExist(@RequestParam(value = "tableId", required = false) Integer tableId,
                                        @RequestParam(value = "tableCode", required = false) String tableCode) {
        if(Objects.isNull(tableId) && Objects.isNull(tableCode))
            throw new GlobalException("No param sent.", HttpStatus.BAD_REQUEST);
        return orderPadService.getOpenedOrderPadOrCreate(tableId, tableCode);
    }
}
