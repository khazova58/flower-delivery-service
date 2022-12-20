package com.khazova.flowerdeliveryservice.service.clients;

import com.khazova.flowerdeliveryservice.model.entity.Operator;
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

    private final Operator operator = new Operator("123456789", "Иван", "Петров", "+79025566779", "ivan@ya.ru");

    @BeforeEach
    void setUp() {
        sut = new OperatorServiceImpl(repository);
    }

    @Test
    @DisplayName("Создание нового оператора")
    void createNewOperatorTest() {
        assertEquals("123456789", sut.createNewOperator(operator));
    }

    @Test
    @DisplayName("Удалить оператора из базы по идентификатору")
    void deleteOperatorByIDTest(){
        Mockito.when(repository.findById("123456789")).thenReturn(Optional.of(operator));
            assertTrue(sut.deleteOperatorByID("123456789"));
    }

    @Test
    @DisplayName("Найти оператора по идентификатору")
    void findOneOperatorByID() {
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(operator));
        Operator result = sut.findOneOperatorByID(operator.getOperatorID());
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
        Mockito.when(repository.findById("123456789")).thenReturn(Optional.of(operator));
        assertTrue(sut.deleteOperatorByID("123456789"));
    }
}