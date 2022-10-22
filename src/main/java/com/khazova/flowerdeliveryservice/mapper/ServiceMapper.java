package com.khazova.flowerdeliveryservice.mapper;

import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;
import com.khazova.flowerdeliveryservice.model.DTO.CourierDTO;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;

public interface ServiceMapper {
    Client clientDtoToEntity(ClientDTO clientDTO);

    ClientDTO mapToClientResponse(Client client);

    CourierDTO mapToCourierResponse(Courier courier);

    Courier courierDtoToEntity(CourierDTO courierDTO);
}
