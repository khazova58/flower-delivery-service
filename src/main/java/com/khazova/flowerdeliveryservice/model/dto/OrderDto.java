package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String clientId;
    private String addressClient;
    private String addressDelivery;
}