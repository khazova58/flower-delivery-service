package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.CourierDto;
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
    @Operation(summary = "Новый курьер")
    public String newCourier(CourierDto courier) {
        return courierService.newCourier(courier);
    }

    @GetMapping
    @Operation(summary = "Найти всех курьеров")
    public List<CourierDto> getAllCourier() {
        return courierService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Найти курьера")
    public CourierDto getCourierNameByID(@PathVariable String id) {
        return courierService.findOneCourierByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить курьера")
    public boolean updateCourier(@PathVariable String id, @RequestBody CourierDto updateCourier) {
        return courierService.updateCourier(id, updateCourier);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить курьера")
    public boolean deleteCourier(@PathVariable String id) {
        return courierService.deleteCourier(id);
    }
}
