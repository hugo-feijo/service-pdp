package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Menu;
import com.pdp.servicepdp.model.dto.MenuDTO;
import com.pdp.servicepdp.model.dto.MenuResponseDTO;
import com.pdp.servicepdp.repository.MenuRepositoy;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.RollbackException;
import java.util.stream.Collectors;

@Service
public class MenuService {
    private final MenuRepositoy menuRepositoy;
    private final ItemService itemService;
    private final RestaurantUnityService restaurantUnityService;

    private final SimpMessagingTemplate simpMessagingTemplate;

    public MenuService(MenuRepositoy menuRepositoy, ItemService itemService, RestaurantUnityService restaurantUnityService, SimpMessagingTemplate simpMessagingTemplate) {
        this.menuRepositoy = menuRepositoy;
        this.itemService = itemService;
        this.restaurantUnityService = restaurantUnityService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public MenuResponseDTO create(MenuDTO menuDTO) {
        var menu = menuDTOToMenu(menuDTO);
        try {
            menuRepositoy.save(menu);
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
        var menu = menuRepositoy.getMenuByRestaurantUnityId(restaurantUnityId);
        if (menu.isEmpty())
            throw new GlobalException("Menu not found", HttpStatus.NOT_FOUND);
        return new MenuResponseDTO(menu.get());
    }

    public MenuResponseDTO updateClientMenu(Integer restaurantUnityId){
        var menu = this.getMenuByRestaurantUnityId(restaurantUnityId);
        simpMessagingTemplate.convertAndSendToUser(restaurantUnityId.toString(), "/restaurant-unity/update", menu);// /client/1/restaurant-unity/update
        return menu;
    }
}
