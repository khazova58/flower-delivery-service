package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithIdDto;
import org.springframework.data.domain.Pageable;

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
    ClientWithIdDto newClient(ClientDto client);

    /**
     * Возвращает всех клиентов
     *
     * @return List клиентов
     */
    List<ClientDto> findAllClients();

    /**
     * Возвращает имя и фамилию клиента по ID
     *
     * @param id клиента
     * @return name, lastName клиента
     */
    ClientDto findOneClientById(String id);

    /**
     * Поиск клиента(-ов) по ФИО
     *
     * @param firstName фамилия
     * @param name      имя
     * @param lastName  отчество
     * @param pageable
     * @return список клиентов, клиента или null
     */
    List<ClientDto> findClientByFIO(String firstName,
                                    String name,
                                    String lastName,
                                    Pageable pageable);

    /**
     * Редактирование клиента по ID
     *
     * @return execution message
     */
    boolean updateClient(String id,
                         ClientDto updateClient);

    /**
     * Удаление клиента из БД
     *
     * @param id клиента
     * @return execution message
     */
    boolean deleteClientById(String id);
}
