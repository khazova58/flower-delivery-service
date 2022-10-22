package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.dto.ClientDTO;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;

import java.util.List;

/**
 * Сервис работы с клиентами
 */

public interface ClientService {
    /**
     * Добавление нового клиента в БД
     *
     * @param client клиент
     * @return ID клиента
     */
    ClientDtoWithId newClient(ClientDTO client);

    /**
     * Возвращает всех клиентов
     *
     * @return List клиентов
     */
    List<ClientDTO> findAllClients();

    /**
     * Возвращает имя и фамилию клиента по ID
     *
     * @param id клиента
     * @return name, lastName клиента
     */
    ClientDTO findOneClientByID(String id);

    /**
     * Редактирование клиента по ID
     *
     * @return execution message
     */
    boolean updateClient(String id, ClientDTO updateClient);

    /**
     * Удаление клиента из БД
     *
     * @param id клиента
     * @return execution message
     */
    boolean deleteClientById(String id);
}
