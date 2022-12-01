package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import com.khazova.flowerdeliveryservice.service.orders.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @Operation(summary = "Создать новый заказ")
    public NewOrderDto newOrder(@Valid @RequestBody OrderDto order) {
        return ordersService.newOrder(order);
    }

    @GetMapping
    @Operation(summary = "Получить все заказы")
    public List<FindOrderDto> findAllOrders() {
        return ordersService.findAllOrders();
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Получить заказы клиента")
    public List<FindOrderDto> getOrderByIdClient(@PathVariable String clientId) {
        return ordersService.getOrdersByClientId(clientId);
    }

    @GetMapping("/courier/{courierId}")
    @Operation(summary = "Получить заказы курьера")
    public List<FindOrderDto> getOrderByIdCourier(@PathVariable String courierId) {
        return ordersService.getOrderByCourierId(courierId);
    }

    @DeleteMapping("/{orderId}")
    @Operation(summary = "Удалить заказ")
    public boolean deleteOrder(@PathVariable String orderId) {
        return ordersService.deleteOrder(orderId);
    }


    @PutMapping("/{orderId}")
    @Operation(summary = "Изменить статус заказа")
    public boolean changeStatusOrder(@PathVariable String orderId, @RequestParam OrderStatus updateStatus) {
        return ordersService.changeStatusOrder(orderId, updateStatus);
    }
}
