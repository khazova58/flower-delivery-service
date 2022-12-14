package com.khazova.flowerdeliveryservice.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FindOrderDto {
    private String status;
    private String nameClient;
    private String lastName;
    private String addressDelivery;
    private Date dateOfOrder;
}
