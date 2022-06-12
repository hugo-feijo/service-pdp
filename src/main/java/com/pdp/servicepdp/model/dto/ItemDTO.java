package com.pdp.servicepdp.model.dto;

import java.util.Set;

public class ItemDTO implements java.io.Serializable{

    private String title;
    private String description;

    private Double value;
    private Integer categoryId;
    private Set<Integer> picturesId;

    public ItemDTO() {
    }

    public ItemDTO(String title, Double value, String description, Integer categoryId, Set<Integer> picturesId) {
        this.title = title;
        this.value = value;
        this.description = description;
        this.categoryId = categoryId;
        this.picturesId = picturesId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Set<Integer> getPicturesId() {
        return picturesId;
    }

    public void setPicturesId(Set<Integer> picturesId) {
        this.picturesId = picturesId;
    }
}
