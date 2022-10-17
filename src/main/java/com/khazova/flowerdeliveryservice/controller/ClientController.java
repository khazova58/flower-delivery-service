package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;
import com.khazova.flowerdeliveryservice.service.clients.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client/")
@Tag(name = "Клиент")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @Operation(description = "Новый клиент")
    public String newClient(ClientDTO client) {
        return "newClient";//TODO
    }

    @GetMapping("/find/{id}")
    public String getClientNameByID(@PathVariable int id) {
        return "Найден клиент";//TODO
    }

    @GetMapping("/find")
    public List<ClientDTO> getAllClient() {
        return null;//TODO
    }

    @PutMapping("/{id}")
    public String updateClient(@PathVariable int id) {
        return "update Client";//TODO
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable int id) {
        return "delete Client";//TODO
    }
}
