package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO-класс для ответа- представление объекта Client в формате Имя, Фамилия, Телефон и eMail
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
}
