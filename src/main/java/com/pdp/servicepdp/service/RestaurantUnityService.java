package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.RestaurantUnity;
import com.pdp.servicepdp.model.dto.RestaurantTableDTO;
import com.pdp.servicepdp.model.dto.RestaurantUnityDTO;
import com.pdp.servicepdp.repository.OrderPadRepository;
import com.pdp.servicepdp.repository.RestaurantTableRepository;
import com.pdp.servicepdp.repository.RestaurantUnityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantUnityService {
    private final RestaurantUnityRepository restaurantUnityRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantService restaurantService;
    private final OrderPadRepository orderPadRepository;

    public RestaurantUnityService(RestaurantUnityRepository restaurantUnityRepository, RestaurantTableRepository restaurantTableRepository,
                                  RestaurantService restaurantService, OrderPadRepository orderPadRepository) {
        this.restaurantUnityRepository = restaurantUnityRepository;
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantService = restaurantService;
        this.orderPadRepository = orderPadRepository;
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

    public List<RestaurantTableDTO> getRestaurantTables(Integer id) {
        var restaurantTablesDTO = new ArrayList<RestaurantTableDTO>();
        var tables = restaurantTableRepository.findByRestaurantUnityId(id);
        tables.forEach(restaurantTable -> {
            var orderPads = orderPadRepository.findByRestaurantTableIdAndClosedAtIsNull(restaurantTable.getId());
            restaurantTablesDTO.add(new RestaurantTableDTO(restaurantTable, orderPads));
        });
        return restaurantTablesDTO;
    }
}
