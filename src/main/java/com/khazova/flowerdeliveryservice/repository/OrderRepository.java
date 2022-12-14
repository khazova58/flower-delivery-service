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
            "and (:status is null or o.status=:status) " +
            "and ((:start is null or :end is null) or o.createDateTime between :start and :end)")
    List<Order> findOrdersByRequest(@Param("clientId") String clientId,
                                    @Param("status") OrderStatus status,
                                    @Param("start") Date start,
                                    @Param("end") Date end,
                                    Sort sort);
}