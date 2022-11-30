package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.CourierDto;
import com.khazova.flowerdeliveryservice.service.couriers.CourierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @ResponseStatus(HttpStatus.CREATED)
    public String newCourier(@Valid @RequestBody CourierDto courier) {
        return courierService.newCourier(courier);
    }

    @GetMapping
    @Operation(summary = "Найти всех курьеров")
    public List<CourierDto> getAllCourier() {
        return courierService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Найти курьера")
    public CourierDto getCourierNameByID(@NotNull @PathVariable String id) {
        return courierService.findOneCourierByID(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить курьера")
    public boolean updateCourier(@NotNull @PathVariable String id, @Valid @RequestBody CourierDto updateCourier) {
        return courierService.updateCourier(id, updateCourier);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить курьера")
    public boolean deleteCourier(@NotNull @PathVariable String id) {
        return courierService.deleteCourier(id);
    }
}
