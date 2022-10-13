package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.DTO.OrderDTO;
import com.khazova.flowerdeliveryservice.service.orders.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrdersService ordersService;

    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public String newOrder(OrderDTO order) {
        return null;
    }

    @GetMapping("/find")
    public List<OrderDTO> allOrder() {
        return null;
    }

    @GetMapping("/find/{id}")
    public List<OrderDTO> getOrderByIDClient(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    public String updateOrder(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        return null;
    }
}
