package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.exception.ResourceNotFoundException;
import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithIdDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.mapper.UserMapper;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис для работы с клиентом
 */
@Service
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final UserMapper mapper;

    public ClientServiceImpl(ClientRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Получить клиента по id
     *
     * @param id клиента
     * @return найденного клиента или ошибку
     */
    private Client getClient(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь с id '" + id + "' не найден"));
    }

    /**
     * Запись нового клиента в БД
     *
     * @param clientDTO клиент
     * @return id нового клиента
     */
    @Override
    @Transactional
    public ClientWithIdDto newClient(ClientDto clientDTO) {
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
        return findClients.stream()
                .map(client -> mapper.clientMapToDTO(client))
                .toList();
    }

    /**
     * Поиск клиента по ID
     *
     * @param id клиента
     * @return найденный клиент
     */
    @Override
    public ClientDto findOneClientById(String id) {
        Client client = getClient(id);
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
        Client client = getClient(id);
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
        getClient(id);
        repository.deleteById(id);
        return true;
    }
}
