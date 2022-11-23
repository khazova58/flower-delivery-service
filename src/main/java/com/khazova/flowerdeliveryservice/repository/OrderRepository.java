package com.khazova.flowerdeliveryservice.repository;

import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

 List<Order> findOrdersByClient(Client client);

 List<Order> findOrdersByCourier(Courier courier);
}
