package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.service.orders.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Заказы")
public class OrderController {

    private final OrdersService ordersService;

    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    @Operation(summary = "Создать новую запись")
    public String newOrder(OrderDto order) {
        return ordersService.newOrder(order);
    }

    @GetMapping
    @Operation(summary = "Получить все записи")
    public List<OrderDto> allOrder() {
        return null;
    }//todo реализовать  метод

    @GetMapping("/{id}")
    @Operation(summary = "Получить запись по идентификатору")
    public List<OrderDto> getOrderByIDClient(@PathVariable int id) {
        return null;
    } //todo реализовать  метод

    @PutMapping("/{id}")
    @Operation(summary = "Обновить запись")
    public boolean updateOrder(@PathVariable int id) {
        return false;
    }    //todo реализовать  метод

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить запись")
    public boolean deleteOrder(@PathVariable int id) {
        return false;
    }     //todo реализовать  метод
}
