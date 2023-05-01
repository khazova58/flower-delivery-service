package com.khazova.flowerdeliveryservice.repository;

import com.khazova.flowerdeliveryservice.SpringBootAppTest;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ClientRepositoryPostgresTest extends SpringBootAppTest {

    @Autowired
    private ClientRepository repository;

    @Test
    @DisplayName(value = "Вернуть клиента по email")
    public void findByEmail_shouldFindClient_whenExists() {
        Optional<Client> found = repository.findByEmail("irishka@yandex.ru");
        assertThat(found.get().getLastName()).isEqualTo("Данилина");
    }


    @Test
    @DisplayName(value = "Вернуть клиента по ФИО")
    public void findClientByFIO_shouldFindClient_whenExists() {
        List<Client> foundClients = repository.findClientByFIO("Соколова", "Светлана", "Владимировна", Pageable.unpaged());
        assertThat(foundClients.size()).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "Вернуть клиентов по ФИО без учета регистра")
    public void findClientByFIO_shouldFindClients_whenExists() {
        List<Client> foundClients = repository.findClientByFIO("соколов", null, null, Pageable.unpaged());
        assertThat(foundClients.size()).isEqualTo(2);
    }

    @Test
    @DisplayName(value = "Вернуть клиента по id")
    public void findByClientId_shouldFindClient_whenExists() {
        Optional<Client> found = repository.findByClientId("2");
        assertThat(found.get().getLastName()).isEqualTo("Иванов");
    }
}
