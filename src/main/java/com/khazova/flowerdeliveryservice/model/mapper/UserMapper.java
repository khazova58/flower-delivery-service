package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.*;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    ClientDto clientMapToDTO(Client client);

    ClientWithOrdersDto clientMapToDtoWithOrders(Client client);

    ClientWithIdDto clientMapToDtoWithId(Client client);

    Client updateClientFromUpdateClientRequest(UpdateClientRequest updateClientRequest, @MappingTarget Client client);

    Client dtoMapToClient(ClientDto clientDTO);

    CourierDto courierMapToDTO(Courier courier);

    Courier dtoMapToCourier(CourierDto courierDTO);
}
