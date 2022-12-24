package com.khazova.flowerdeliveryservice.controller;

import com.khazova.flowerdeliveryservice.model.dto.CreateOperatorResponse;
import com.khazova.flowerdeliveryservice.model.dto.OperatorDTO;
import com.khazova.flowerdeliveryservice.model.dto.UpdateOperatorResponse;
import com.khazova.flowerdeliveryservice.model.entity.Operator;
import com.khazova.flowerdeliveryservice.service.operators.OperatorServiceImpl;
import org.junit.jupiter.api.Disabled;
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

@WebMvcTest(OperatorController.class)
public class OperatorControllerTest {

    @MockBean
    private OperatorServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    private final Operator operator = new Operator("Иван", "Петров", "+79025566779", "ivan@ya.ru");

    private final OperatorDTO operatorDTO = new OperatorDTO("Ivan", "Petrov", "+79025566779", "ivan@ya.ru");
    private final String testID = "testID";

    @Test
    @DisplayName("Создание нового оператора")
    public void createNewOperatorTest() throws Exception {

        Mockito.when(service.createNewOperator(any())).thenReturn(new CreateOperatorResponse(testID));
        mockMvc.perform(post("/api/v1/operator")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                  "name": "Ivan",
                                  "lastName": "Petrov",
                                  "phoneNumber": "+79025566779",
                                  "email": "ivan@ya.ru"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(testID));
    }

    @Test
    @DisplayName("Удалить оператора из базы по идентификатору")
    void deleteOperatorByIDTest() throws Exception {
        Mockito.when(service.deleteOperatorByID(testID)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/operator/{id}", testID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").value("true"));
    }

    @Test
    @DisplayName("Найти оператора по идентификатору")
    void findOneOperatorByID() throws Exception {
        Mockito.when(service.findOneOperatorByID(testID)).thenReturn(operatorDTO);

        mockMvc.perform(get("/api/v1/operator/{id}", testID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ivan"));
    }

    @Test
    @DisplayName("Получить список всех операторов")
    void findAllOperatorsTest() throws Exception {
        Mockito.when(service.findAllOperators()).thenReturn(List.of(operatorDTO));

        String expected = "[{\"name\":\"Ivan\",\"lastName\":\"Petrov\",\"phoneNumber\":\"+79025566779\",\"email\":\"ivan@ya.ru\"}]";

        MvcResult result = mockMvc.perform(get("/api/v1/operator"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Обновить существующую запись оператора")
    @Disabled
    void updateOperatorByIDTest() throws Exception {
        Mockito.when(service.updateOperatorByID(testID, operatorDTO))
                .thenReturn(new UpdateOperatorResponse(true));

        mockMvc.perform(put("/api/v1/operator/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                "id": "testID",
                                "data": {
                                  "name": "Ivan",
                                  "lastName": "Petrov",
                                  "phoneNumber": "+79025566779",
                                  "email": "ivan@ya.ru"
                                  }
                                }
                                """))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.updated").value("true"));
    }

}
