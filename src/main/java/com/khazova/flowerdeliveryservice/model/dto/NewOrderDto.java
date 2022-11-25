package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

@Data
public class NewOrderDto {
    private String status;
    private String clientId;
    private String addressClient;
    private String addressDelivery;
}
