package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

/**
 * DTO-класс - представление объекта Courier в формате Имя, Фамилия и Телефон
 */
@Data
public class CourierDto {
    private String name;
    private String lastName;
    private String phoneNumber;
}
