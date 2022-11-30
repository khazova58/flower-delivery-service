package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OrderDto {
    @NotBlank(message = "не должно быть пустым")
    private String clientId;
    @NotBlank(message = "не должно быть пустым")
    private String addressClient;
    @NotBlank(message = "не должно быть пустым")
    private String addressDelivery;
}