package com.khazova.flowerdeliveryservice.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private String addressClient;
    private String addressDelivery;
    private String statusOrder;
    private int versionOrder;
    private Date dateOfOrder;
    private Date dateOfUpdate;
}
