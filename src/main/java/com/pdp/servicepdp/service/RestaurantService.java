package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Restaurant;
import com.pdp.servicepdp.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant create(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public Restaurant findById(Integer id) {
        var restaurant = restaurantRepository.findById(id);
        if (restaurant.isEmpty())
            throw new GlobalException("Restaurant not found", HttpStatus.NOT_FOUND);
        return restaurant.get();
    }
}
