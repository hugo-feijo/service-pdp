package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.RestaurantUnity;
import com.pdp.servicepdp.model.dto.RestaurantUnityDTO;
import com.pdp.servicepdp.repository.RestaurantUnityDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RestaurantUnityService {
    private final RestaurantUnityDAO restaurantUnityDAO;
    private final RestaurantService restaurantService;

    public RestaurantUnityService(RestaurantUnityDAO restaurantUnityDAO, RestaurantService restaurantService) {
        this.restaurantUnityDAO = restaurantUnityDAO;
        this.restaurantService = restaurantService;
    }

    public RestaurantUnity create(RestaurantUnityDTO restaurantUnityDTO) {
        var restaurantUnity = new RestaurantUnity();
        var restaurant = restaurantService.findById(restaurantUnityDTO.getRestaurantId());

        restaurantUnity.setName(restaurantUnityDTO.getName());
        restaurantUnity.setRestaurant(restaurant);

        restaurantUnityDAO.save(restaurantUnity);
        return restaurantUnity;
    }

    public RestaurantUnity findById(Integer id) {
        var restaurantUnity = restaurantUnityDAO.findById(id);
        if (restaurantUnity.isEmpty())
            throw new GlobalException("Restaurant Unity not found", HttpStatus.NOT_FOUND);
        return restaurantUnity.get();
    }
}
