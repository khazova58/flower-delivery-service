package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.exception.Error;
import com.khazova.flowerdeliveryservice.exception.ServiceException;
import com.khazova.flowerdeliveryservice.model.dto.*;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import com.khazova.flowerdeliveryservice.model.mapper.UserMapper;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import org.springframework.data.domain.Pageable;
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
                .orElseThrow(() -> new ServiceException(Error.CLIENT_NOT_FOUND, id));
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
        if (repository.findByEmail(clientDTO.getEmail()).isPresent())
            throw new ServiceException(Error.EMAIL_EXIST, clientDTO.getEmail());
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
     * @return найденный клиент с количеством заказов
     */
    @Override
    public ClientWithOrdersDto findOneClientById(String id) {
        Client client = repository.findByClientId(id).orElseThrow(() -> new ServiceException(Error.CLIENT_NOT_FOUND, id));
        List<Order> clientOrders = client.getOrders();
        ClientWithOrdersDto clientDto = mapper.clientMapToDtoWithOrders(client);
        clientDto.setCountOrders(clientOrders.size());
        return clientDto;
    }

    /**
     * Поиск клиента по ФИО
     *
     * @param findClientRequest тело запроса
     * @param pageable          сортировка
     * @return найденные клиенты
     */
    @Override
    public List<ClientDto> findClientByFIO(FindClientRequest findClientRequest,
                                           Pageable pageable) {
        List<Client> clientByFIO = repository.findClientByFIO(findClientRequest.getLastName(), findClientRequest.getFirstName(), findClientRequest.getMiddleName(), pageable);
        return clientByFIO.stream()
                .map(client -> mapper.clientMapToDTO(client))
                .toList();
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
    public ClientDto updateClient(String id, UpdateClientRequest updateClient) {
        Client saveClient = repository.save(mapper.updateClientFromUpdateClientRequest(updateClient, getClient(id)));
        return mapper.clientMapToDTO(saveClient);
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
