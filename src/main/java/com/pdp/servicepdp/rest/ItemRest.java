package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.dto.ItemDTO;
import com.pdp.servicepdp.model.dto.ItemResponseDTO;
import com.pdp.servicepdp.service.ItemService;
import com.pdp.servicepdp.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/item")
public class ItemRest {

    private final ItemService itemService;
    private final MenuService menuService;

    public ItemRest(ItemService itemService, MenuService menuService) {
        this.itemService = itemService;
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDTO> createClient(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(itemDTO));
    }

    @CrossOrigin
    @PutMapping("/status/{id}")
    public void updateStatus(@PathVariable Integer id, @RequestHeader("x-restaurant-unity-id") Integer restaurantUnityId) {
        itemService.updateStatus(id);
        menuService.updateClientMenu(restaurantUnityId);
    }
}
