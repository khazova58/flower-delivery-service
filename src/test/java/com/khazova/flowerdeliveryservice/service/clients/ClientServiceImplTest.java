package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.mapper.ServiceMapper;
import com.khazova.flowerdeliveryservice.mapper.UserMapper;
import com.khazova.flowerdeliveryservice.model.dto.ClientDTO;
import com.khazova.flowerdeliveryservice.model.dto.ClientDtoWithId;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository repository;

    private final ServiceMapper mapper = new UserMapper();

    private ClientServiceImpl sut;

    private ClientDTO dto = new ClientDTO( "Sveta", "Sokolova", "89253651414", "test@mail.ru");

    @BeforeEach
    void setUp() {
        sut = new ClientServiceImpl(repository, mapper);
    }

    @Test
    void newClient() {
    }

    @Test
    void findAllClients() {
    }

    @Test
    void findOneClientByID() {
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(new Client("Sveta", "Sokolova", "89253651414", "test@mail.ru")));
        ClientDTO client = sut.findOneClientByID("testId");
        assertEquals("Sveta", client.getName());
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClientById() {
    }
}