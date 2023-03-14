package com.pdp.servicepdp.model.dto;

public class RestaurantTableCreationDTO implements java.io.Serializable{

    private String name;
    private Integer restaurantUnityId;

    public RestaurantTableCreationDTO() {
    }

    public RestaurantTableCreationDTO(String name, Integer restaurantUnityId) {
        this.name = name;
        this.restaurantUnityId = restaurantUnityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRestaurantUnityId() {
        return restaurantUnityId;
    }

    public void setRestaurantUnityId(Integer restaurantUnityId) {
        this.restaurantUnityId = restaurantUnityId;
    }
}
