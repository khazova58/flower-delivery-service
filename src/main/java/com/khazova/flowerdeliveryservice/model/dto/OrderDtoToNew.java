package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDtoToNew {
    private String status;
    private String clientId;
    private String addressClient;
    private String addressDelivery;
    private Date dateOfOrder;
    private String courier;
}
