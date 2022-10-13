package com.khazova.flowerdeliveryservice.model.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-класс - представление объекта Courier в формате Имя, Фамилия и Телефон
 */
@Getter
@Setter
public class CourierDTO {
    private String name;
    private String lastName;
    private String phoneNumber;
}
