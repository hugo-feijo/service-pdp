package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable,Integer> {
    List<RestaurantTable> findByRestaurantUnityId(Integer id);
}
