package com.khazova.flowerdeliveryservice.mapper;

import com.khazova.flowerdeliveryservice.model.DTO.OrderDTO;
import com.khazova.flowerdeliveryservice.model.entity.Order;

public interface OderMapper {

    OrderDTO entityMapToOrderDto(Order order);

    //Orders dtoMapToEntity(OrderDTO dto);
}
