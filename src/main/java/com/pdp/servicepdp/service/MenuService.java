package com.pdp.servicepdp.service;

import com.pdp.servicepdp.model.Menu;
import com.pdp.servicepdp.model.dto.MenuDTO;
import com.pdp.servicepdp.repository.MenuDAO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuService {
    private final MenuDAO menuDAO;
    private final ItemService itemService;
    private final RestaurantUnityService restaurantUnityService;

    public MenuService(MenuDAO menuDAO, ItemService itemService, RestaurantUnityService restaurantUnityService) {
        this.menuDAO = menuDAO;
        this.itemService = itemService;
        this.restaurantUnityService = restaurantUnityService;
    }

    public Menu create(MenuDTO menuDTO) {
        var restaurantUnity = restaurantUnityService.findById(menuDTO.getRestaurantUnityId());
        var items = menuDTO.getItemsId().stream().map(itemService::findById).collect(Collectors.toSet());
        var menu = new Menu(0, items, restaurantUnity);
        menuDAO.create(menu);
        return menu;
    }

}
