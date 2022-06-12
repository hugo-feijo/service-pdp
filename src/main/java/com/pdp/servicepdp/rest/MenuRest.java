package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.dto.MenuDTO;
import com.pdp.servicepdp.model.dto.MenuResponseDTO;
import com.pdp.servicepdp.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${cors.url}")
@RequestMapping("/v1/api/menu")
public class MenuRest {

    private final MenuService menuService;

    public MenuRest(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<MenuResponseDTO> createClient(@RequestBody MenuDTO menuDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.create(menuDTO));
    }

    @GetMapping("/restaurant-unity/{id}")
    public MenuResponseDTO getMenuByRestaurantUnityId(@PathVariable Integer id){
        return menuService.getMenuByRestaurantUnityId(id);
    }
}
