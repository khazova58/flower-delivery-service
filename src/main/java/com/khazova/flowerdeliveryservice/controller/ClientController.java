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
    @Operation(summary = "Создать новую запись")
    public String newClient(@RequestBody ClientDTO client) {
        String newClientID = clientService.newClient(client);
        return "ID нового пользователя: " + newClientID;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить запись по индентификатору")
    public ClientDTO findOneClient(@PathVariable String id) {
        return clientService.findOneClientByID(id);
    }

    @GetMapping
    @Operation(summary = "Получить все записи")
    public List<ClientDTO> findAllClients() {
        return clientService.findAllClients();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить запись с заданным индентификаторм")
    public boolean updateClient(@PathVariable String id, @RequestBody ClientDTO updateClient) {
        return clientService.updateClient(id, updateClient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить запись с заданным идентификатором")
    public boolean deleteClient(@PathVariable String id) {
        return clientService.deleteClientById(id);
    }
}
