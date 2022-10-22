package com.khazova.flowerdeliveryservice.mapper;

import com.khazova.flowerdeliveryservice.model.dto.ClientDTO;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.model.dto.CourierDTO;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;

public interface ServiceMapper {
    Client clientDtoToEntity(ClientDTO clientDTO);

    ClientDTO mapToClientResponse(Client client);

    CourierDTO mapToCourierResponse(Courier courier);

    Courier courierDtoToEntity(CourierDTO courierDTO);

    ClientDtoWithId mapClientDtoWithId(Client client);
}
