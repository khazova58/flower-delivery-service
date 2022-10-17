package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.DTO.CourierDTO;
import com.khazova.flowerdeliveryservice.service.couriers.CourierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/couriers")
public class CourierController {

    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    public String newCourier(CourierDTO courier) {
        return "новый";//TODO
    }

    @GetMapping
    public List<CourierDTO> getAllCourier() {
        return null;//TODO
    }

    @GetMapping("/{id}")
    public String getCourierNameByID(@PathVariable int id) {
        return "клиент";//TODO
    }

    @PutMapping("/{id}")
    public String updateCourier(@PathVariable int id) {
        return "обновить";//TODO
    }

    @DeleteMapping("/{id}")
    public String deleteCourier(@PathVariable int id) {
        return "удалить";//TODO
    }
}
