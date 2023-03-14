package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.RestaurantUnity;
import com.pdp.servicepdp.model.dto.RestaurantTableDTO;
import com.pdp.servicepdp.model.dto.RestaurantUnityDTO;
import com.pdp.servicepdp.service.RestaurantUnityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/restaurant-unity")
public class RestaurantUnityRest {

    private final RestaurantUnityService restaurantUnityService;

    public RestaurantUnityRest(RestaurantUnityService restaurantUnityService) {
        this.restaurantUnityService = restaurantUnityService;
    }

    @PostMapping
    public ResponseEntity<RestaurantUnity> createClient(@RequestBody RestaurantUnityDTO restaurantUnityDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantUnityService.create(restaurantUnityDTO));
    }


    @CrossOrigin
    @GetMapping("/{id}/tables")
    public  ResponseEntity<List<RestaurantTableDTO>> getRestaurantTables(@PathVariable Integer id) {
        return  ResponseEntity.ok(restaurantUnityService.getRestaurantTables(id));
    }
}
