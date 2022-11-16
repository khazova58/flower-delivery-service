package com.khazova.flowerdeliveryservice.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO-класс для ответа- представление объекта Client в формате Имя, Фамилия, Телефон и eMail
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ClientDTO {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;

    public ClientDTO(String name, String lastName, String phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
