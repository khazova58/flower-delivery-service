package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.mapper.ServiceMapper;
import com.khazova.flowerdeliveryservice.mapper.UserMapper;
import com.khazova.flowerdeliveryservice.model.dto.ClientDTO;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository repository;

    private final ServiceMapper mapper = new UserMapper();

    private ClientServiceImpl sut;

    private final ClientDTO dto = new ClientDTO("Sveta", "Sokolova", "89253651414", "test@mail.ru");

    private final Client client = new Client("Sveta", "Sokolova", "89253651414", "test@mail.ru");

    @BeforeEach
    void setUp() {
        sut = new ClientServiceImpl(repository, mapper);
    }

    @Test
    @DisplayName("Создание нового клиента")
    void newClient() {
        Mockito.when(repository.save(any())).thenReturn(client);
        ClientDtoWithId withId = sut.newClient(dto);
        assertEquals(client.getName(), withId.getName());
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
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(client));
        ClientDTO result = sut.findOneClientByID("testId");
        assertEquals("Sveta", result.getName());
    }

    @Test
    @DisplayName("Обновление клиента по ID")
    void updateClient() {
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(client));
        assertTrue(sut.updateClient("testId", dto));
    }

    @Test
    @DisplayName("Удаление клиента с заданным ID")
    void deleteClientById() {
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(client));
        assertTrue(sut.deleteClientById("testId"));
    }
}