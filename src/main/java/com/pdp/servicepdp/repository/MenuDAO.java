package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MenuDAO extends JpaRepository<Menu,Integer> {
    @Query("select m from Menu m WHERE m.restaurantUnity.id = ?1")
    public Optional<Menu> getMenuByRestaurantUnityId(Integer restaurantUnityId);
//    {
//        String jpql=;
//        return super.read(jpql, restaurantUnityId).stream().findFirst();
//    }
}
