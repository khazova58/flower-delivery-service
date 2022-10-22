package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.mapper.ServiceMapper;
import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с клиентом
 */
@Service
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ServiceMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ServiceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Запись нового клиента в БД
     *
     * @param clientDTO клиент
     * @return id нового клиента
     */
    @Override
    @Transactional
    public String newClient(ClientDTO clientDTO) {
        Client newClient = mapper.clientDtoToEntity(clientDTO);
        repository.save(newClient);
        return String.valueOf(newClient.getClientID());
    }

    /**
     * Поиск всех клиентов
     *
     * @return list клиентов
     */
    @Override
    public List<ClientDTO> findAllClients() {
        List<Client> findClients = repository.findAll();
        List<ClientDTO> dtoClient = new ArrayList<>();
        for (Client client : findClients) {
            dtoClient.add(mapper.mapToClientResponse(client));
        }
        return dtoClient;
    }

    /**
     * Поиск клиента по ID
     *
     * @param id клиента
     * @return найденный клиент
     */
    @Override
    public ClientDTO findOneClientByID(String id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));//todo обработать ошибку
        return mapper.mapToClientResponse(client);
    }

    /**
     * Обновить данные клиента
     *
     * @param id           клиента
     * @param updateClient данные клиента
     * @return true
     */
    @Override
    @Transactional
    public boolean updateClient(String id, ClientDTO updateClient) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));//todo обработать ошибку
        client.setName(updateClient.getName());
        client.setLastName(updateClient.getLastName());
        client.setPhoneNumber(updateClient.getPhoneNumber());
        client.setEmail(updateClient.getEmail());
        repository.save(client);
        return true;
    }

    /**
     * удалить клиента из БД
     *
     * @param id клиента
     * @return true
     */
    @Override
    @Transactional
    public boolean deleteClientById(String id) {
        repository.deleteById(id);
        return true;
    }
}
