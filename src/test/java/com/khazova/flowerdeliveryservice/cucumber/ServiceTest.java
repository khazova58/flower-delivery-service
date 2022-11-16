package com.khazova.flowerdeliveryservice.cucumber;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Autowired
    private Service sut;

    @MockBean
    private Repo repo;

//    @BeforeEach
//    void setUp() {
////        MockitoAnnotations.openMocks(this);
//        sut = new Service(repo);
//    }

    @Test
    void saveHello() {
        Mockito.when(repo.save(any())).thenReturn("сохраненный");
        String test = sut.saveHello("Test");
        assertEquals("Привет сохраненный Test", test);
    }
}