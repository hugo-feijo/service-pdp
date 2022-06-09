package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.Restaurant;
import com.pdp.servicepdp.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/restaurant")
public class RestaurantRest {

    private final RestaurantService restaurantService;

    public RestaurantRest(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createClient(@RequestBody Restaurant restaurant) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.create(restaurant));
    }
}
