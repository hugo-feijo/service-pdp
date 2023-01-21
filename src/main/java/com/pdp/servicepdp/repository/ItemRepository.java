package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
