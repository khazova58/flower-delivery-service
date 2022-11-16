package com.khazova.flowerdeliveryservice.service.couriers;

import com.khazova.flowerdeliveryservice.model.dto.CourierDto;

import java.util.List;

public interface CourierService {
    /**
     * Добавление нового клиента в БД
     *
     * @param newCourier курьер
     * @return ID курьера
     */
    String newCourier(CourierDto newCourier);

    /**
     * Возвращает всех курьеров
     *
     * @return List курьеров
     */
    List<CourierDto> findAll();

    /**
     * Возвращает имя и фамилию курьера по ID
     *
     * @param id курьера
     * @return name, lastName курьера
     */
    CourierDto findOneCourierByID(String id);

    /**
     * Редактирование курьера по ID
     *
     * @param id курьера
     * @return execution message
     */
    boolean updateCourier(String id, CourierDto updateCourier);

    /**
     * Удаление курьера из БД
     *
     * @param id курьера
     * @return execution message
     */
    boolean deleteCourier(String id);
}
