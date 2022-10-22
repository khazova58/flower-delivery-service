package com.khazova.flowerdeliveryservice.mapper;

import com.khazova.flowerdeliveryservice.model.DTO.OrderDTO;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements OderMapper {

    @Override
    public OrderDTO entityMapToOrderDto(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setAddressClient(order.getAddressClient());
        dto.setAddressDelivery(order.getAddressDelivery());
        return dto;
    }

//    @Override
//    public Orders dtoMapToEntity(OrderDTO dto) {
//        return new Orders();
//    }
}
