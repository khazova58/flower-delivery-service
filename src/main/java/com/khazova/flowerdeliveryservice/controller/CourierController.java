package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.DTO.CourierDTO;
import com.khazova.flowerdeliveryservice.service.couriers.CourierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/couriers")
@Tag(name = "Курьер")
public class CourierController {

    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    @Operation(summary = "Создать новую запись")
    public String newCourier(CourierDTO courier) {
        return "новый";//TODO
    }

    @GetMapping
    @Operation(summary = "Получить все записи")
    public List<CourierDTO> getAllCourier() {
        return null;//TODO
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить запись по идентификатору")
    public String getCourierNameByID(@PathVariable String id) {
        return "клиент";//TODO
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить запись с заданным идентификатором")
    public String updateCourier(@PathVariable String id) {
        return "обновить";//TODO
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить запись с заданным индентификаторм")
    public String deleteCourier(@PathVariable String id) {
        return "удалить";//TODO
    }
}
