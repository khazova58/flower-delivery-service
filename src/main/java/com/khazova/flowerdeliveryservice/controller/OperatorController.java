package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.OperatorDTO;
import com.khazova.flowerdeliveryservice.model.dto.UpdateOperatorResponse;
import com.khazova.flowerdeliveryservice.service.operators.OperatorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/operator", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Оператор")
public class OperatorController {

    private final OperatorServiceImpl operatorServiceImpl;

    public  OperatorController(OperatorServiceImpl operatorServiceImpl){
        this.operatorServiceImpl = operatorServiceImpl;
    }

    @PostMapping
    @Operation(summary = "Создать нового оператора")
    @ResponseStatus(HttpStatus.CREATED)
    public OperatorDTO createNewOperator(OperatorDTO operatorDTO) {
        return operatorServiceImpl.createNewOperator(operatorDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить оператора с заданным идентификатором")
    public boolean deleteOperatorByID(@PathVariable String id) {
        return operatorServiceImpl.deleteOperatorByID(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить оператора по индентификатору")
    public OperatorDTO findOneOperatorByID(@PathVariable String id) {
        return operatorServiceImpl.findOneOperatorByID(id);
    }

    @GetMapping
    @Operation(summary = "Получить всех операторов")
    public List<OperatorDTO> findAllOperators() {
         return operatorServiceImpl.findAllOperators();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить оператора с заданным индентификаторм")
    public UpdateOperatorResponse updateOperatorByID(@PathVariable String id, @RequestBody OperatorDTO operatorDTO) {
       return operatorServiceImpl.updateOperatorByID(id, operatorDTO);
    }
}