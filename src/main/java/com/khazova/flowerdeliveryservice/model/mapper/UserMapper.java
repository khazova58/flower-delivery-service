package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithOrdersDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithIdDto;
import com.khazova.flowerdeliveryservice.model.dto.CourierDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    ClientDto clientMapToDTO(Client client);

    ClientWithOrdersDto clientMapToDtoWithOrders(Client client);

    ClientWithIdDto clientMapToDtoWithId(Client model);

    Client dtoMapToClient(ClientDto clientDTO);

    CourierDto courierMapToDTO(Courier courier);

    Courier dtoMapToCourier(CourierDto courierDTO);
}
