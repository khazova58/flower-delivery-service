package com.khazova.flowerdeliveryservice.repository;

import com.khazova.flowerdeliveryservice.model.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, String> {
}