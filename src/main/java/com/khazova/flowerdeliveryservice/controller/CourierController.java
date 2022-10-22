package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.CourierDTO;
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
        return courierService.newCourier(courier);
    }

    @GetMapping
    @Operation(summary = "Получить все записи")
    public List<CourierDTO> getAllCourier() {
        return courierService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить запись по идентификатору")
    public CourierDTO getCourierNameByID(@PathVariable String id) {
        return courierService.findOneCourierByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить запись с заданным идентификатором")
    public boolean updateCourier(@PathVariable String id, @RequestBody CourierDTO updateCourier) {
        return courierService.updateCourier(id, updateCourier);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить запись с заданным индентификаторм")
    public boolean deleteCourier(@PathVariable String id) {
        return courierService.deleteCourier(id);
    }
}
