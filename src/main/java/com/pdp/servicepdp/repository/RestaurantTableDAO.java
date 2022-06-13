package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RestaurantTableDAO extends JpaRepository<RestaurantTable,Integer> {
}
