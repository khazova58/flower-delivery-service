package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.entity.Operator;
import com.khazova.flowerdeliveryservice.service.operators.OperatorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/operator")
@Tag(name = "Оператор")
public class OperatorController {

    private final OperatorServiceImpl operatorServiceImpl;

    public  OperatorController(OperatorServiceImpl operatorServiceImpl){
        this.operatorServiceImpl = operatorServiceImpl;
    }

    @PostMapping
    @Operation(summary = "Создать нового оператора")
    public String createNewOperator(Operator operator) {
        operatorServiceImpl.createNewOperator(operator);
        return "";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить оператора с заданным идентификатором")
    public String deleteOperatorByID(@PathVariable String id) {
        operatorServiceImpl.deleteOperatorByID(id);
        return "Оператор " + id + " удалён и бд.";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить оператора по индентификатору")
    public Operator findOneOperatorByID(@PathVariable String id) {
        return operatorServiceImpl.findOneOperatorByID(id);

    }

    @GetMapping
    @Operation(summary = "Получить всех операторов")
    public List<Operator> findAllOperators() {
         return operatorServiceImpl.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить оператора с заданным индентификаторм")
    public void updateOperatorByID(@PathVariable String id, Operator operator) {
       operatorServiceImpl.updateOperatorByID(id, operator);
    }

}


