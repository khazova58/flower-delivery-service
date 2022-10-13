package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;

import java.util.List;

/**
 * Сервис работы с клиентами
 */
public interface ClientService {
    /**
     * Добавление нового клиента в БД
     * @param client клиент
     * @return ID клиента
     */
    String newClient(ClientDTO client);

    /**
     * Возвращает всех клиентов
     *
     * @return List клиентов
     */
    List<ClientDTO> getAllClient();

    /**
     * Возвращает имя и фамилию клиента по ID
     * @param id клиента
     * @return name, lastName клиента
     */
    String getClientNameByID(int id);

    /**
     * Редактирование клиента по ID
     * @param id клиента
     * @return execution message
     */
    String updateClient(int id);

    /**
     * Удаление клиента из БД
     * @param id клиента
     * @return execution message
     */
    String deleteClient(int id);
}
