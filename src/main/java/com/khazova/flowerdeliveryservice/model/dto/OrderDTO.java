package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private String addressClient;
    private String addressDelivery;
    private String clientId;
    private String courierId;
}
