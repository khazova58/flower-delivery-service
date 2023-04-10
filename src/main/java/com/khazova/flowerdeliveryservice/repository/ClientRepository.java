package com.khazova.flowerdeliveryservice.repository;

import com.khazova.flowerdeliveryservice.model.entity.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByEmail(String id);

    @Query(value = """
            SELECT o FROM Client o
            WHERE (:firstName IS NULL OR LOWER(o.firstName) LIKE LOWER(CONCAT (:firstName, '%')))
            AND (:name IS NULL OR LOWER(o.name) LIKE LOWER(CONCAT(:name, '%')))
            AND (:lastName IS NULL OR LOWER(o.lastName) LIKE LOWER(CONCAT(:lastName, '%')))
            """)
    List<Client> findClientByFIO(@Param("firstName") String firstName,
                                 @Param("name") String name,
                                 @Param("lastName") String lastName,
                                 Pageable pageable);

    @EntityGraph(attributePaths = "orders")
    @Query("""
            SELECT c FROM Client c 
            JOIN FETCH c.orders
            WHERE c.clientId = :id
                        """)
    Optional<Client> findByClientId(String id);
}
