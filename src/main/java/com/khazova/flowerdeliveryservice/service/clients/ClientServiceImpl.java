package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.mapper.ClientMapper;
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
    private final ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
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
    public ClientDtoWithId newClient(ClientDto clientDTO) {
        Client newClient = mapper.dtoMapToClient(clientDTO);
        repository.save(newClient);
        return mapper.clientMapToDtoWithId(newClient);
    }

    /**
     * Поиск всех клиентов
     *
     * @return list клиентов
     */
    @Override
    public List<ClientDto> findAllClients() {
        List<Client> findClients = repository.findAll();
        List<ClientDto> dtoClient = new ArrayList<>();
        for (Client client : findClients) {
            dtoClient.add(mapper.clientMapToDTO(client));
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
    public ClientDto findOneClientByID(String id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));//todo обработать ошибку
        return mapper.clientMapToDTO(client);
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
    public boolean updateClient(String id, ClientDto updateClient) {
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
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));//todo обработать ошибку
        repository.deleteById(id);
        return true;
    }
}
