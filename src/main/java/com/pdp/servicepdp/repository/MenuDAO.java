package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MenuDAO extends dao<Menu> {
    public Optional<Menu> getMenuByRestaurantUnityId(Integer restaurantUnityId) {
        String jpql="select m from Menu m WHERE m.restaurantUnity.id = ?1";
        return super.read(jpql, restaurantUnityId).stream().findFirst();
    }
}
