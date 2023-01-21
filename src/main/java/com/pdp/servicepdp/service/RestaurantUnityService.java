package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.RestaurantUnity;
import com.pdp.servicepdp.model.dto.RestaurantUnityDTO;
import com.pdp.servicepdp.repository.RestaurantUnityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RestaurantUnityService {
    private final RestaurantUnityRepository restaurantUnityRepository;
    private final RestaurantService restaurantService;

    public RestaurantUnityService(RestaurantUnityRepository restaurantUnityRepository, RestaurantService restaurantService) {
        this.restaurantUnityRepository = restaurantUnityRepository;
        this.restaurantService = restaurantService;
    }

    public RestaurantUnity create(RestaurantUnityDTO restaurantUnityDTO) {
        var restaurantUnity = new RestaurantUnity();
        var restaurant = restaurantService.findById(restaurantUnityDTO.getRestaurantId());

        restaurantUnity.setName(restaurantUnityDTO.getName());
        restaurantUnity.setRestaurant(restaurant);

        restaurantUnityRepository.save(restaurantUnity);
        return restaurantUnity;
    }

    public RestaurantUnity findById(Integer id) {
        var restaurantUnity = restaurantUnityRepository.findById(id);
        if (restaurantUnity.isEmpty())
            throw new GlobalException("Restaurant Unity not found", HttpStatus.NOT_FOUND);
        return restaurantUnity.get();
    }
}
