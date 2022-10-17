package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;
import com.khazova.flowerdeliveryservice.service.clients.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public String newClient(ClientDTO client) {
        return "newClient";//TODO
    }

    @GetMapping("/{id}")
    public String getClientNameByID(@PathVariable String id) {
        return "Найден клиент";//TODO
    }

    @GetMapping
    public List<ClientDTO> getAllClient() {
        return null;//TODO
    }

    @PutMapping("/{id}")
    public String updateClient(@PathVariable String id) {
        return "update Client";//TODO
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable String id) {
        return "delete Client";//TODO
    }
}
