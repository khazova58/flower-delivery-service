package com.khazova.flowerdeliveryservice.repository;

import com.khazova.flowerdeliveryservice.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findByEmail(String id);
}
