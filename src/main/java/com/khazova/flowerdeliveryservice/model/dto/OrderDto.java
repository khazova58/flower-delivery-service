package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OrderDto {
    @NotBlank(message = "не должно быть пустым")
    private String clientId;
    @Size(min = 10, max = 150)
    private String addressClient;
    @Size(min = 10, max = 150)
    private String addressDelivery;
}