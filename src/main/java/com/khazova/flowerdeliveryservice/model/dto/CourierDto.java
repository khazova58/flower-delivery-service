package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * DTO-класс - представление объекта Courier в формате Имя, Фамилия и Телефон
 */
@Data
public class CourierDto {
    @NotBlank(message = "не должно быть пустым")
    private String name;

    @NotBlank(message = "не должно быть пустым")
    private String lastName;

    @Pattern(regexp = "^(8|[+]7)[0-9]{10}$", message = "должно соответствовать записи (+7/8)9555555")
    private String phoneNumber;
}
