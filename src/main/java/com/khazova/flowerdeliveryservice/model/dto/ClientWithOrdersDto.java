package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientWithOrdersDto {

    private String lastName;

    private String firstName;

    private String middleName;

    private String phoneNumber;

    private String email;

    private int countOrders;
}
