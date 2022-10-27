package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ClientDtoWithId{
    private String id;

    @Override
    public String toString() {
        return id;
    }
}
