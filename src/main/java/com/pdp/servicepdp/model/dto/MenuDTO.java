package com.pdp.servicepdp.model.dto;

import java.util.Set;

public class MenuDTO implements java.io.Serializable{

    private Integer restaurantUnityId;
    private Set<Integer> ItemsId;

    public MenuDTO() {
    }

    public MenuDTO(Integer restaurantUnityId, Set<Integer> itemsId) {
        this.restaurantUnityId = restaurantUnityId;
        ItemsId = itemsId;
    }

    public Integer getRestaurantUnityId() {
        return restaurantUnityId;
    }

    public void setRestaurantUnityId(Integer restaurantUnityId) {
        this.restaurantUnityId = restaurantUnityId;
    }

    public Set<Integer> getItemsId() {
        return ItemsId;
    }

    public void setItemsId(Set<Integer> itemsId) {
        ItemsId = itemsId;
    }
}
