package com.pdp.servicepdp.model.dto;

public class RestaurantUnityDTO implements java.io.Serializable{

    private String name;
    private Integer restaurantId;

    public RestaurantUnityDTO() {
    }

    public RestaurantUnityDTO(String name, Integer restaurantId) {
        this.name = name;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
