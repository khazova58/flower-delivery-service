package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с клиентом
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public String newClient(ClientDTO client) {
        return null;
    }

    @Override
    public List<ClientDTO> getAllClient() {
        return null;
    }

    @Override
    public String getClientNameByID(int id) {
        return null;
    }

    @Override
    public String updateClient(int id) {
        return null;
    }

    @Override
    public String deleteClient(int id) {
        return null;
    }
}
