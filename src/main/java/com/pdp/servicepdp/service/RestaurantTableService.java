package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.RestaurantTable;
import com.pdp.servicepdp.repository.RestaurantTableDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

    private final RestaurantTableDAO restaurantTableDAO;

    public RestaurantTableService(RestaurantTableDAO restaurantTableDAO) {
        this.restaurantTableDAO = restaurantTableDAO;
    }

    public RestaurantTable findById(Integer id) {
        var restaurantTable = restaurantTableDAO.read(RestaurantTable.class, id);
        if (restaurantTable == null)
            throw new GlobalException("RestaurantTable not found", HttpStatus.NOT_FOUND);
        return restaurantTable;
    }
}
