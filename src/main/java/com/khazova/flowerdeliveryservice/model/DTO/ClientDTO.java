package com.khazova.flowerdeliveryservice.model.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * DTO-класс для ответа- представление объекта Client в формате Имя, Фамилия, Телефон и eMail
 */

@Getter
@Setter
public class ClientDTO {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
}
