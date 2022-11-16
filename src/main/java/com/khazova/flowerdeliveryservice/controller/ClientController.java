package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.service.clients.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @Operation(summary = "Создать новую запись")
    public ClientDtoWithId newClient(@RequestBody ClientDto client) {
        return clientService.newClient(client);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить запись по индентификатору")
    public ClientDto findOneClient(@PathVariable String id) {
        return clientService.findOneClientByID(id);
    }

    @GetMapping
    @Operation(summary = "Получить все записи")
    public List<ClientDto> findAllClients() {
        return clientService.findAllClients();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить запись с заданным индентификаторм")
    public boolean updateClient(@PathVariable String id, @RequestBody ClientDto updateClient) {
        return clientService.updateClient(id, updateClient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить запись с заданным идентификатором")
    public boolean deleteClient(@PathVariable String id) {
        return clientService.deleteClientById(id);
    }
}
