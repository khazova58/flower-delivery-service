package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * DTO-класс для ответа- представление объекта Client в формате Имя, Фамилия, Телефон и eMail
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    @NotBlank(message = "не должно быть пустым")
    private String name;

    @NotBlank(message = "не должно быть пустым")
    private String lastName;

    @Pattern(regexp = "^(8|[+]7)[0-9]{10}$", message = "должно соответствовать записи (+7/8)9555555")
    private String phoneNumber;

    @Email(message = "должен соответствовать формату test@test.ru")
    @NotBlank(message = "не должно быть пустым")
    private String email;
}
