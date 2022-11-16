package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

@Data
public class ClientDtoWithId {
    private String clientID;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
}
