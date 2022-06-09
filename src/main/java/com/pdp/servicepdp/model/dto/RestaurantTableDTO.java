package com.pdp.servicepdp.model.dto;

public class RestaurantTableDTO implements java.io.Serializable{

    private String identification;
    private Integer restaurantUnityId;

    public RestaurantTableDTO() {
    }

    public RestaurantTableDTO(String identification, Integer restaurantUnityId) {
        this.identification = identification;
        this.restaurantUnityId = restaurantUnityId;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Integer getRestaurantUnityId() {
        return restaurantUnityId;
    }

    public void setRestaurantUnityId(Integer restaurantUnityId) {
        this.restaurantUnityId = restaurantUnityId;
    }
}
