package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.dto.RequestForClientDto;
import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import com.khazova.flowerdeliveryservice.service.orders.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Заказы")
@EnableSpringDataWebSupport
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
    @Operation(summary = "Получить все заказы (pagination)")
    public List<FindOrderDto> findAllOrders(@ParameterObject @PageableDefault(size = 10, sort = "createDateTime", direction = Sort.Direction.DESC) Pageable pageable) {
        return ordersService.findAllOrders(pageable);
    }

    @PostMapping("/client/")
    @Operation(summary = "Получить заказы клиента по критерию")
    public List<FindOrderDto> getOrdersForClientWithParam(@Valid @RequestBody RequestForClientDto request,
                                                          @ParameterObject @SortDefault(value = "createDateTime", direction = Sort.Direction.DESC) Sort sort) {
        return ordersService.getOrdersByClientWithParam(request, sort);
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
