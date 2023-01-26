package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.dto.ItemDTO;
import com.pdp.servicepdp.model.dto.ItemResponseDTO;
import com.pdp.servicepdp.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/item")
public class ItemRest {

    private final ItemService itemService;

    public ItemRest(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDTO> createClient(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(itemDTO));
    }

    @CrossOrigin
    @PutMapping("/status/{id}")
    public void updateStatus(@PathVariable Integer id) {
        itemService.updateStatus(id);
    }
}
