package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Restaurant;
import com.pdp.servicepdp.repository.RestaurantDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantDAO restaurantDAO;

    public RestaurantService(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    public Restaurant create(Restaurant restaurant) {
        restaurantDAO.create(restaurant);
        return restaurant;
    }

    public Restaurant findById(Integer id) {
        var restaurant = restaurantDAO.read(Restaurant.class, id);
        if (restaurant == null)
            throw new GlobalException("Restaurant not found", HttpStatus.NOT_FOUND);
        return restaurant;
    }
}
