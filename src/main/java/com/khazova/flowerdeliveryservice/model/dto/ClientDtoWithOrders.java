package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO-класс для ответа- представление объекта Client в формате Имя, Фамилия, Телефон и eMail
 */
@Data
@AllArgsConstructor
public class ClientDtoWithOrders {

    private String firstName;

    private String name;

    private String lastName;

    private String phoneNumber;

    private String email;

    private int countOrders;
}
