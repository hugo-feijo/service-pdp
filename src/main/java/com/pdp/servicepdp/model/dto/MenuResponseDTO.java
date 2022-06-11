package com.pdp.servicepdp.model.dto;

import com.pdp.servicepdp.model.Item;
import com.pdp.servicepdp.model.Menu;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuResponseDTO implements Serializable {
    private Set<CategoryResponseDTO> categories;

    public MenuResponseDTO(Menu menu) {
        Map<Integer, List<Item>> itemsByCategory = menu.getItems().stream().collect(Collectors.groupingBy(w -> w.getCategory().getId()));
        this.categories = new HashSet<>();
        for (var entry : itemsByCategory.entrySet()) {
            categories.add(new CategoryResponseDTO(entry.getValue()));
        }
    }

    public MenuResponseDTO(Set<CategoryResponseDTO> categories) {
        this.categories = categories;
    }

    public Set<CategoryResponseDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryResponseDTO> categories) {
        this.categories = categories;
    }

    private static class CategoryResponseDTO implements Serializable{
        private String name;
        private Set<ItemResponseDTO> items;

        public CategoryResponseDTO(String name, Set<ItemResponseDTO> items) {
            this.name = name;
            this.items = items;
        }

        public CategoryResponseDTO(List<Item> value) {
            this.setName(value.get(0).getCategory().getDescription());
            this.setItems(value.stream().map(ItemResponseDTO::new).collect(Collectors.toSet()));
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<ItemResponseDTO> getItems() {
            return items;
        }

        public void setItems(Set<ItemResponseDTO> items) {
            this.items = items;
        }
    }
}
