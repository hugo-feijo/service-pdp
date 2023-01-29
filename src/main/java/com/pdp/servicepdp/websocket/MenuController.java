package com.pdp.servicepdp.websocket;

import com.pdp.servicepdp.model.dto.MenuRequest;
import com.pdp.servicepdp.model.dto.MenuResponseDTO;
import com.pdp.servicepdp.service.MenuService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @MessageMapping("/menu")
    MenuResponseDTO gettingMenu(@Payload MenuRequest menuRequest) throws InterruptedException {
        return menuService.updateClientMenu(menuRequest.restaurantUnityId());
    }
}
