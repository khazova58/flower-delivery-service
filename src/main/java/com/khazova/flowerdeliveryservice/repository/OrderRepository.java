package com.khazova.flowerdeliveryservice.repository;

import com.khazova.flowerdeliveryservice.model.entity.Courier;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findOrdersByCourier(Courier courier);

    @Query(value = "SELECT o FROM Order o WHERE (o.client.clientId= :clientId) " +
            "AND (:status IS NULL OR o.status=:status) " +
            "AND ((:start IS NULL OR :end IS NULL) OR o.createDateTime BETWEEN :start AND :end)")
    List<Order> findOrdersByRequest(@Param("clientId") String clientId,
                                    @Param("status") OrderStatus status,
                                    @Param("start") Date start,
                                    @Param("end") Date end,
                                    Sort sort);
}