package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientRequest {

    private String lastName;

    private String firstName;

    private String middleName;

    @Pattern(regexp = "^(8|[+]7)[0-9]{10}$", message = "должно соответствовать записи (+7/8)9555555")
    private String phoneNumber;

    @Email(message = "должен соответствовать формату test@test.ru")
    private String email;
}
