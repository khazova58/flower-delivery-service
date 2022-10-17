package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.DTO.OrderDTO;
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
    public String newOrder(OrderDTO order) {
        return null;
    }

    @GetMapping
    @Operation(summary = "Получить все записи")
    public List<OrderDTO> allOrder() {
        return null;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить запись по идентификатору")
    public List<OrderDTO> getOrderByIDClient(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить запись")
    public String updateOrder(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить запись")
    public String deleteOrder(@PathVariable int id) {
        return null;
    }
}
