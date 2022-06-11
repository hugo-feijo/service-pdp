package com.pdp.servicepdp.model.dto;

import com.pdp.servicepdp.model.Item;

import java.util.Set;
import java.util.stream.Collectors;

public class ItemResponseDTO implements java.io.Serializable{

    private String title;
    private String description;
    private String categoryName;
    private Set<String> pictures;

    public ItemResponseDTO() {
    }

    public ItemResponseDTO(String title, String description, String categoryName, Set<String> pictures) {
        this.title = title;
        this.description = description;
        this.categoryName = categoryName;
        this.pictures = pictures;
    }

    public ItemResponseDTO(Item item) {
        this.setTitle(item.getTitle());
        this.setDescription(item.getDescription());
        this.setCategoryName(item.getCategory().getDescription());
        this.setPictures(item.getPictures().stream().map(itemPictures -> itemPictures.getPicture().getUrl()).collect(Collectors.toSet()));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<String> getPictures() {
        return pictures;
    }

    public void setPictures(Set<String> pictures) {
        this.pictures = pictures;
    }
}
