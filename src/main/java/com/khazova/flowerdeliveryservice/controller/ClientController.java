package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.ClientDTO;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.service.clients.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE) //, consumes = MediaType.APPLICATION_JSON_VALUE
@Tag(name = "Клиент")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @Operation(summary = "Создать новую запись")
    public ClientDtoWithId newClient(@RequestBody ClientDTO client) {
        return clientService.newClient(client);
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
