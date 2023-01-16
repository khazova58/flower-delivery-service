package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.dto.CreateOperatorResponse;
import com.khazova.flowerdeliveryservice.model.dto.OperatorDTO;
import com.khazova.flowerdeliveryservice.model.entity.Operator;
import com.khazova.flowerdeliveryservice.model.mapper.OperatorMapper;
import com.khazova.flowerdeliveryservice.repository.OperatorRepository;
import com.khazova.flowerdeliveryservice.service.operators.OperatorServiceImpl;
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
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class OperatorServiceImplTest {

    @Mock
    private OperatorRepository repository;

    private OperatorServiceImpl sut;

    private OperatorMapper operatorMapper = new OperatorMapper();

    private final Operator operator = new Operator("Иван", "Петров", "+79025566779", "ivan@ya.ru");
    private final OperatorDTO operatorDTO = new OperatorDTO("Иван", "Петров", "+79025566779", "ivan@ya.ru");
    private final String testID = "testID";

    @BeforeEach
    void setUp() {
        sut = new OperatorServiceImpl(repository, operatorMapper);
    }

    @Test
    @DisplayName("Создание нового оператора")
    void createNewOperatorTest() {
        operator.setOperatorID(testID);
        Mockito.when(repository.saveAndFlush(any())).thenReturn(operator);
        CreateOperatorResponse response = sut.createNewOperator(operatorDTO);
        assertEquals(testID, response.getId());
    }

    @Test
    @DisplayName("Удалить оператора из базы по идентификатору")
    void deleteOperatorByIDTest(){
        Mockito.when(repository.findById(testID)).thenReturn(Optional.of(operator));
            assertTrue(sut.deleteOperatorByID(testID));
    }

    @Test
    @DisplayName("Найти оператора по идентификатору")
    void findOneOperatorByID() {
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(operator));
        OperatorDTO result = sut.findOneOperatorByID(operator.getOperatorID());
        assertEquals(operator.getName(), result.getName());
    }

    @Test
    @DisplayName("Получить список всех операторов")
    void findAllOperatorsTest() {
        List<Operator> allOperators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            allOperators.add(operator);
        }
        Mockito.when(repository.findAll()).thenReturn(allOperators);
        assertEquals(5, sut.findAllOperators().size());
    }

    @Test
    @DisplayName("Обновить существующую запись оператора")
    void updateOperatorByIDTest(){
        Mockito.when(repository.findById(testID)).thenReturn(Optional.of(operator));
        assertTrue(sut.deleteOperatorByID(testID));
    }
}