package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithIdDto;
import com.khazova.flowerdeliveryservice.model.dto.UpdateClientRequest;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import com.khazova.flowerdeliveryservice.model.mapper.UserMapperImpl;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository repository;

    private final UserMapperImpl mapper = new UserMapperImpl();

    private ClientServiceImpl sut;

    private final ClientDto dto = new ClientDto("Sokolova", "Svetlana", "Olegovna", "89253651414", "test@mail.ru");

    private final Client client = new Client("Sokolova", "Svetlana", "Olegovna", "89253651414", "test@mail.ru");

    private final UpdateClientRequest update = new UpdateClientRequest("Sokolova", "Svetlana", "Olegovna", "89253651414", "test@mail.ru");

    @BeforeEach
    void setUp() {
        sut = new ClientServiceImpl(repository, mapper);
    }

    @Test
    @DisplayName("Создание нового клиента")
    void newClient() {
        Mockito.when(repository.save(any())).thenReturn(client);
        ClientWithIdDto withId = sut.newClient(dto);
        assertEquals(client.getLastName(), withId.getLastName());
    }

    @Test
    @DisplayName("Получение списка всех клиентов")
    void findAllClients() {
        ArrayList<Client> allClients = new ArrayList<>();
        allClients.add(client);
        Mockito.when(repository.findAll()).thenReturn(allClients);
        assertEquals(1, sut.findAllClients().size());
    }

    @Test
    @DisplayName("Получение клиента по ID")
    void findOneClientByID() {
        List<Order> ordersMock = new ArrayList<>();
        ordersMock.add(new Order(client, "Moscow", "Penza"));
        client.setOrders(ordersMock);
        Mockito.when(repository.findByClientId(any())).thenReturn(Optional.of(client));
        assertEquals(1, sut.findOneClientById("testId").getCountOrders());
    }

    @Test
    @DisplayName("Обновление клиента по ID")
    void updateClient() {
        Mockito.when(repository.findById("testId")).thenReturn(Optional.of(client));
        Mockito.when(repository.save(any())).thenReturn(client);
        sut.updateClient("testId", update);
        assertEquals("Sokolova", update.getLastName());
    }

    @Test
    @DisplayName("Удаление клиента с заданным ID")
    void deleteClientById() {
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(client));
        assertTrue(sut.deleteClientById("testId"));
    }
}