package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDtoToFind;
import com.khazova.flowerdeliveryservice.model.dto.OrderDtoToNew;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    @Mapping(target = "clientId", source = "client.clientId")
    OrderDto orderMapToDto(Order order);

    @Mappings({
            @Mapping(target = "clientId", source = "client.clientId"),
            @Mapping(target = "courier", source = "courier.courierId")
    })
    OrderDtoToNew entityMapDtoToNew(Order order);

    @Mappings({
            @Mapping(target = "nameClient", source = "client.name"),
            @Mapping(target = "lastName", source = "client.lastName")
    })
    OrderDtoToFind entityMapDtoToFind(Order order);
}
