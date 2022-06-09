package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.RestaurantTable;
import com.pdp.servicepdp.model.dto.RestaurantTableDTO;
import com.pdp.servicepdp.service.RestaurantTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/restaurant-table")
public class RestaurantTableRest {

    private final RestaurantTableService restaurantTableService;

    public RestaurantTableRest(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @PostMapping
    public ResponseEntity<RestaurantTable> createClient(@RequestBody RestaurantTableDTO restaurantTableDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantTableService.create(restaurantTableDTO));
    }
}
