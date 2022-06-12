package com.pdp.servicepdp.model.dto;

import com.pdp.servicepdp.model.Item;

import java.util.Set;
import java.util.stream.Collectors;

public class ItemResponseDTO implements java.io.Serializable{

    private Integer id;
    private String title;
    private String description;

    private Double value;
    private String categoryName;
    private Set<String> pictures;

    public ItemResponseDTO() {
    }

    public ItemResponseDTO(Integer id, String title, String description, String categoryName, Set<String> pictures) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryName = categoryName;
        this.pictures = pictures;
    }

    public ItemResponseDTO(Item item) {
        this.setId(item.getId());
        this.setTitle(item.getTitle());
        this.setValue(item.getValue());
        this.setDescription(item.getDescription());
        this.setCategoryName(item.getCategory().getDescription());
        this.setPictures(item.getPictures().stream().map(itemPictures -> itemPictures.getPicture().getUrl()).collect(Collectors.toSet()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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
