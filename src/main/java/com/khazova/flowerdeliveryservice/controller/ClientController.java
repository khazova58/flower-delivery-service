package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;
import com.khazova.flowerdeliveryservice.service.clients.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@Tag(name = "Клиент")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @Operation(summary = "Создать новю запись")
    public String newClient(ClientDTO client) {
        return "newClient";//TODO
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить запись по индентификатору")
    public String getClientNameByID(@PathVariable String id) {
        return "Найден клиент";//TODO
    }

    @GetMapping
    @Operation(summary = "Получить все записи")
    public List<ClientDTO> getAllClient() {
        return null;//TODO
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить запись с заданным индентификаторм")
    public String updateClient(@PathVariable String id) {
        return "update Client";//TODO
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить запись с заданным идентификатором")
    public String deleteClient(@PathVariable String id) {
        return "delete Client";//TODO
    }
}
