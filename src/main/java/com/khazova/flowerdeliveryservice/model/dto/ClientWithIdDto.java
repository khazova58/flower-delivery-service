package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

@Data
public class ClientWithIdDto {
    private String clientId;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
}
