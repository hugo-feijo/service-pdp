package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.abstratas.dao;
import com.pdp.servicepdp.model.ItemPictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ItemPicturesDAO extends JpaRepository<ItemPictures,Integer> {
}
