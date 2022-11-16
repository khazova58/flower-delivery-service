package com.khazova.flowerdeliveryservice.model.mapper;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.model.dto.CourierDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {

    ClientDto clientMapToDTO(Client client);

    @Mapping(target = "clientID", source = "clientId")
    ClientDtoWithId clientMapToDtoWithId(Client model);

    Client dtoMapToClient(ClientDto clientDTO);

    CourierDto courierMapToDTO(Courier courier);

    Courier dtoMapToCourier(CourierDto courierDTO);
}
