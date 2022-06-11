package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Menu;
import com.pdp.servicepdp.model.dto.MenuDTO;
import com.pdp.servicepdp.model.dto.MenuResponseDTO;
import com.pdp.servicepdp.repository.MenuDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.RollbackException;
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

    public MenuResponseDTO create(MenuDTO menuDTO) {
        var menu = menuDTOToMenu(menuDTO);
        try {
            menuDAO.create(menu);
        } catch (RollbackException e) {
            if(e.getMessage().contains("menu_restaurantunity_id_key"))
                throw new GlobalException("This unity already have a Menu.", HttpStatus.BAD_REQUEST);
            throw e;
        }
        return new MenuResponseDTO(menu);
    }

    private Menu menuDTOToMenu(MenuDTO menuDTO) {
        var restaurantUnity = restaurantUnityService.findById(menuDTO.getRestaurantUnityId());
        var items = menuDTO.getItemsId().stream().map(itemService::findById).collect(Collectors.toSet());
        var menu = new Menu(0, items, restaurantUnity);
        return menu;
    }

    public MenuResponseDTO getMenuByRestaurantUnityId(Integer restaurantUnityId) {
        var menu = menuDAO.getMenuByRestaurantUnityId(restaurantUnityId);
        if (menu.isEmpty())
            throw new GlobalException("Menu not found", HttpStatus.NOT_FOUND);
        return new MenuResponseDTO(menu.get());
    }
}
