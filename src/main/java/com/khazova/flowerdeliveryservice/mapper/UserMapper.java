package com.khazova.flowerdeliveryservice.mapper;

import com.khazova.flowerdeliveryservice.model.dto.ClientDTO;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.model.dto.CourierDTO;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import org.springframework.stereotype.Component;

/**
 * Преобразование сущностей в удобный формат
 */
@Component
public class UserMapper implements ServiceMapper {
    /**
     * Перевод ответа в сущность Client
     * @param clientDTO ответ
     * @return Client
     */
    @Override
    public Client clientDtoToEntity(ClientDTO clientDTO) {
        return new Client(clientDTO.getName(), clientDTO.getLastName(), clientDTO.getPhoneNumber(), clientDTO.getEmail());
    }

    /**
     * Перевод сущности Client в формат ответа
     * @param client сущность
     * @return сущность в формате Name, LastName, PhoneNumber, Email
     */
    @Override
    public ClientDTO mapToClientResponse(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setLastName(client.getLastName());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setEmail(client.getEmail());
        return dto;
    }

    /**
     * Перевод сущности Courier в формат ответа
     * @param courier сущность  таблицы Courier
     * @return сущность в формате Name, LastName, PhoneNumber
     */
    @Override
    public CourierDTO mapToCourierResponse(Courier courier) {
        CourierDTO dto = new CourierDTO();
        dto.setName(courier.getName());
        dto.setLastName(courier.getLastName());
        dto.setPhoneNumber(courier.getPhoneNumber());
        return dto;
    }

    /**
     * Перевод ответа в сущность Courier
     * @param courierDTO ответ
     * @return Courier
     */
    @Override
    public Courier courierDtoToEntity(CourierDTO courierDTO) {
        return new Courier(courierDTO.getName(), courierDTO.getLastName(), courierDTO.getPhoneNumber());
    }

    public ClientDtoWithId mapClientDtoWithId(Client client){
        ClientDtoWithId dtoWithId = new ClientDtoWithId();
        dtoWithId.setId(client.getClientID());
        return dtoWithId;
    }
}
