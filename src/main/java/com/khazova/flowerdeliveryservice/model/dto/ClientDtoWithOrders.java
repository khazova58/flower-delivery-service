package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDtoWithOrders {

    private String firstName;

    private String name;

    private String lastName;

    private String phoneNumber;

    private String email;

    private int countOrders;
}
