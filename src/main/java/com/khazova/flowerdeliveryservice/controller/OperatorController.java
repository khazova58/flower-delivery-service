package com.khazova.flowerdeliveryservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/operators")
@Tag(name = "Оператор")

public class OperatorController {

    @PutMapping("takeAnOrderToWork/{id}")
    @Operation(summary = "Взять заказ в работу")
        public String takeAnOrderToWork(@PathVariable String id) {
            return "";
    }

    @PutMapping("removeAnOrderFromWork/{id}")
    @Operation(summary = "Удалить заказ из работы")
    public String removeAnOrderFromWork(@PathVariable String id) {
        return "";
    }

    @PutMapping("assignCourier/{id}")
    @Operation(summary = "Назначить курьера")
    public String assignCourier(@PathVariable String id) {
        return "";
    }

    @PutMapping("addOrEditCommentToTheOrder/{id}")
    @Operation(summary = "Добавить или изменить комментарий к заказу")
    public String addOrEditCommentToTheOrder(@PathVariable String id) {
        return "";
    }

}

