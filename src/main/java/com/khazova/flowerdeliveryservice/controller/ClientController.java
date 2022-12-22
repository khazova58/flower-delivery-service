package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithIdDto;
import com.khazova.flowerdeliveryservice.service.clients.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Клиент")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @Operation(summary = "Новый клиент")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientWithIdDto newClient(@Valid @RequestBody ClientDto client) {
        log.info("Создание нового пользователя {}", client);
        return clientService.newClient(client);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск клиента")
    public ClientDto findOneClient(@NotNull @PathVariable String id) {
        log.info("Поиск клиента c id {}", id);
        return clientService.findOneClientById(id);
    }

    @GetMapping
    @Operation(summary = "Получить всех клиентов")
    public List<ClientDto> findAllClients() {
        log.info("Получение списка клиентов");
        return clientService.findAllClients();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить клиента")
    public boolean updateClient(@NotNull @PathVariable String id, @Valid @RequestBody ClientDto updateClient) {
        log.info("Редактирование пользователя с ID: {} {}", id, updateClient);
        return clientService.updateClient(id, updateClient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить клиента")
    public boolean deleteClient(@NotNull @PathVariable String id) {
        log.info("Редактирование пользователя с ID: {}", id);
        return clientService.deleteClientById(id);
    }
}
