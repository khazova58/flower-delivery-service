package com.khazova.flowerdeliveryservice.model.dto;

import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class RequestForClientDto {
    @NotBlank(message = "не должно быть пустым")
    private String clientId;
    private Date startDate;
    private Date endDate;
    private OrderStatus status;
}
