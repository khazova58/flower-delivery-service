package com.khazova.flowerdeliveryservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindClientRequest {
    private String firstName;
    private String name;
    private String lastName;

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName;
    }
}
