package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.Menu;
import com.pdp.servicepdp.model.dto.MenuDTO;
import com.pdp.servicepdp.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/menu")
public class MenuRest {

    private final MenuService menuService;

    public MenuRest(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Menu> createClient(@RequestBody MenuDTO menuDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.create(menuDTO));
    }
}
