package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class FindClientRequest {

    private String lastName;

    private String firstName;

    private String middleName;
}
