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
            WHERE (:lastName IS NULL OR LOWER(o.lastName) LIKE LOWER(CONCAT (:lastName, '%')))
            AND (:firstName IS NULL OR LOWER(o.firstName) LIKE LOWER(CONCAT(:firstName, '%')))
            AND (:middleName IS NULL OR LOWER(o.middleName) LIKE LOWER(CONCAT(:middleName, '%')))
            """)
    List<Client> findClientByFIO(@Param("lastName") String lastName,
                                 @Param("firstName") String firstName,
                                 @Param("middleName") String middleName,
                                 Pageable pageable);

    @EntityGraph(attributePaths = "orders")
    Optional<Client> findByClientId(String id);
}
