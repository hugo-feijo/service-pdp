package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.RestaurantTable;
import com.pdp.servicepdp.model.dto.RestaurantTableCreationDTO;
import com.pdp.servicepdp.repository.RestaurantTableRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantUnityService restaurantUnityService;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository, RestaurantUnityService restaurantUnityService) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantUnityService = restaurantUnityService;
    }

    public RestaurantTable create(RestaurantTableCreationDTO restaurantTableCreationDTO) {
        var restaurantTable = new RestaurantTable();
        var restaurantUnity = restaurantUnityService.findById(restaurantTableCreationDTO.getRestaurantUnityId());

        restaurantTable.setName(restaurantTableCreationDTO.getName());
        restaurantTable.setRestaurantUnity(restaurantUnity);

        restaurantTableRepository.save(restaurantTable);
        return restaurantTable;
    }

    public RestaurantTable findById(Integer id) {
        var restaurantTable = restaurantTableRepository.findById(id);
        if (restaurantTable.isEmpty())
            throw new GlobalException("RestaurantTable not found", HttpStatus.NOT_FOUND);
        return restaurantTable.get();
    }
}
