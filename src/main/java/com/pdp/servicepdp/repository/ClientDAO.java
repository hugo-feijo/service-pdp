package com.pdp.servicepdp.repository;

import com.pdp.servicepdp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client,Integer > {
}
