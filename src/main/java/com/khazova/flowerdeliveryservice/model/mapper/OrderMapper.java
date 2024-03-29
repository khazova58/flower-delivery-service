package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    @Mapping(target = "clientId", source = "client.clientId")
    NewOrderDto entityMapToNewDto(Order order);

    @Mapping(target = "lastName", source = "client.lastName")
    @Mapping(target = "firstName", source = "client.firstName")
    @Mapping(target = "dateOfOrder", source = "order.createDateTime")
    FindOrderDto entityMapToFindDto(Order order);
}
