package com.khazova.flowerdeliveryservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/operator")
@Tag(name = "Оператор")
public class OperatorController {

        @PostMapping
        @Operation(summary = "Создать нового оператора")
        public String newOperator(String temp) {
            return "";
        }
        @DeleteMapping("/{id}")
        @Operation(summary = "Удалить оператора с заданным идентификатором")
        public String deleteOperator(@PathVariable String id) {
            return "";
        }
        @GetMapping("/{id}")
        @Operation(summary = "Получить оператора по индентификатору")
        public String findOneOperator(@PathVariable String id) {
            return "";
        }

        @GetMapping
        @Operation(summary = "Получить всех операторов")
        public String findAllOperators() {
            return "";
        }

        @PutMapping("/{id}")
        @Operation(summary = "Обновить оператора с заданным индентификаторм")
        public String updateOperator(@PathVariable String id) {
            return "";
        }

}


