package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

@Data
public class ClientWithIdDto {
    private String clientId;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
}
