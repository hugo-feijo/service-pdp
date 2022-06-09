package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.RestaurantTable;
import com.pdp.servicepdp.model.dto.RestaurantTableDTO;
import com.pdp.servicepdp.repository.RestaurantTableDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

    private final RestaurantTableDAO restaurantTableDAO;
    private final RestaurantUnityService restaurantUnityService;

    public RestaurantTableService(RestaurantTableDAO restaurantTableDAO, RestaurantUnityService restaurantUnityService) {
        this.restaurantTableDAO = restaurantTableDAO;
        this.restaurantUnityService = restaurantUnityService;
    }

    public RestaurantTable create(RestaurantTableDTO restaurantTableDTO) {
        var restaurantTable = new RestaurantTable();
        var restaurantUnity = restaurantUnityService.findById(restaurantTableDTO.getRestaurantUnityId());

        restaurantTable.setIdentification(restaurantTableDTO.getIdentification());
        restaurantTable.setRestaurantUnity(restaurantUnity);

        restaurantTableDAO.create(restaurantTable);
        return restaurantTable;
    }

    public RestaurantTable findById(Integer id) {
        var restaurantTable = restaurantTableDAO.read(RestaurantTable.class, id);
        if (restaurantTable == null)
            throw new GlobalException("RestaurantTable not found", HttpStatus.NOT_FOUND);
        return restaurantTable;
    }
}
