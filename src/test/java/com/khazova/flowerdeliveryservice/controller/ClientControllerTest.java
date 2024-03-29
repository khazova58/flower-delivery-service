package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.ClientDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithIdDto;
import com.khazova.flowerdeliveryservice.model.dto.ClientWithOrdersDto;
import com.khazova.flowerdeliveryservice.service.clients.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @MockBean
    private ClientService service;

    @Autowired
    private MockMvc mockMvc;

    private final ClientDto dto = new ClientDto("Sokolova", "Svetlana", "Olegovna", "89253651414", "test@mail.ru");

    private final ClientWithOrdersDto dtoWithOrders = new ClientWithOrdersDto("Sokolova", "Svetlana", "Olegovna", "89253651414", "test@mail.ru", 2);

    private final String id = "testId";

    @Test
    @DisplayName("Создание нового клиента")
    void newClient() throws Exception {
        ClientWithIdDto withId = new ClientWithIdDto();
        withId.setClientId(id);

        Mockito.when(service.newClient(any())).thenReturn(withId);

        mockMvc.perform(post("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                  "lastName": "Sokolova",
                                  "firstName": "Sveta",
                                  "middleName": "Olegovna",
                                  "phoneNumber": "89253651414",
                                  "email": "test@mail.ru"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.clientId").value(id));
    }

    @Test
    @DisplayName("Получение клиента по ID")
    void findOneClient() throws Exception {
        Mockito.when(service.findOneClientById("testId")).thenReturn(dtoWithOrders);

        mockMvc.perform(get("/api/v1/clients/{id}", "testId"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Svetlana"));
    }

    @Test
    @DisplayName("Получение списка всех клиентов")
    void findAllClients() throws Exception {
        Mockito.when(service.findAllClients()).thenReturn(
                List.of(dto));

        String expected = "[{\"lastName\":\"Sokolova\",\"firstName\":\"Svetlana\",\"middleName\":\"Olegovna\",\"phoneNumber\":\"89253651414\",\"email\":\"test@mail.ru\"}]";

        MvcResult result = mockMvc.perform(get("/api/v1/clients"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Обновление клиента с заданным ID")
    void updateClient() throws Exception {
        Mockito.when(service.updateClient(any(), any())).thenReturn(dto);

        this.mockMvc.perform(put("/api/v1/clients/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                   "lastName": "Sokolova",
                                   "firstName": "Sveta",
                                   "middleName": "Olegovna",
                                   "phoneNumber": "89253651414",
                                   "email": "test@mail.ru"
                                 }
                                 """))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.lastName").value("Sokolova"));
    }

    @Test
    @DisplayName("Удаление клиента с заданным ID")
    void deleteClient() throws Exception {
        Mockito.when(service.deleteClientById("testId")).thenReturn(true);

        mockMvc.perform(delete("/api/v1/clients/{id}", id))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").value("true"));
    }
}