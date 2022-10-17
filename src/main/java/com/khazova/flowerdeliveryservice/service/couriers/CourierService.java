package com.khazova.flowerdeliveryservice.service.couriers;

import com.khazova.flowerdeliveryservice.model.DTO.CourierDTO;

import java.util.List;

public interface CourierService {
    /**
     * Добавление нового клиента в БД
     *
     * @param courier курьер
     * @return ID курьера
     */
    String newCourier(CourierDTO courier);

    /**
     * Возвращает всех курьеров
     *
     * @return List курьеров
     */
    List<CourierDTO> getAllCourier();

    /**
     * Возвращает имя и фамилию курьера по ID
     *
     * @param id курьера
     * @return name, lastName курьера
     */
    String getCourierNameByID(int id);

    /**
     * Редактирование курьера по ID
     *
     * @param id курьера
     * @return execution message
     */
    String updateCourier(int id);

    /**
     * Удаление курьера из БД
     *
     * @param id курьера
     * @return execution message
     */
    String deleteCourier(int id);
}
