package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import com.khazova.flowerdeliveryservice.model.mapper.OrderMapper;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import com.khazova.flowerdeliveryservice.repository.CourierRepository;
import com.khazova.flowerdeliveryservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrdersServiceImpl implements OrdersService {

    private final OrderRepository orderRepository;

    private final ClientRepository clientRepository;

    private final CourierRepository courierRepository;
    private final OrderMapper mapper;

    public OrdersServiceImpl(OrderRepository repository, ClientRepository clientRepository, CourierRepository courierRepository, OrderMapper mapper) {
        this.orderRepository = repository;
        this.clientRepository = clientRepository;
        this.courierRepository = courierRepository;
        this.mapper = mapper;
    }

    /**
     * Создать новый заказ
     * @param dto представление таблицы Orders
     * @return сохраненный заказ
     */
    @Override
    @Transactional
    public NewOrderDto newOrder(OrderDto dto) {
        String id = dto.getClientId();
        Client newClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));//todo обработать ошибку
        Order order = new Order(newClient, dto.getAddressClient(), dto.getAddressDelivery());
        Order save = orderRepository.save(order);
        return mapper.entityMapToNewDto(save);
    }

    /**
     * Поиск всех заказов
      * @return список заказов
     */
    @Override
    public List<FindOrderDto> findAllOrders() {
        List<Order> foundOrders = orderRepository.findAll();
        List<FindOrderDto> dtoFound = new ArrayList<>();
        for (Order order : foundOrders) {
            dtoFound.add(mapper.entityMapToFindDto(order));
        }
        return dtoFound;
    }

    /**
     * Поиск заказов по клиенту
     * @param clientId идентификатор клиента
     * @return список найденных заказов
     */
    @Override
    public List<FindOrderDto> getOrdersByClientId(String clientId) {
        Client foundClient = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Клиент не найден"));//todo реализовать ошибку
        List<Order> foundOrders = orderRepository.findOrdersByClient(foundClient);
        List<FindOrderDto> dtoFound = new ArrayList<>();
        for (Order order : foundOrders) {
            dtoFound.add(mapper.entityMapToFindDto(order));
        }
        return dtoFound;
    }

    /**
     * Поиск заказов по курьеру
     * @param courierId идентификатор курьера
     * @return список найденных заказов
     */
    @Override
    public List<FindOrderDto> getOrderByCourierId(String courierId) {
        Courier foundCourier = courierRepository.findById(courierId).orElseThrow(() -> new RuntimeException("Клиент не найден"));//todo реализовать ошибку
        List<Order> foundOrders = orderRepository.findOrdersByCourier(foundCourier);
        List<FindOrderDto> dtoFound = new ArrayList<>();
        for (Order order : foundOrders) {
            dtoFound.add(mapper.entityMapToFindDto(order));
        }
        return dtoFound;
    }

    /**
     * Удаление заказа
     * @param id заказа
     * @return true в случае успеха
     */
    @Override
    @Transactional
    public boolean deleteOrder(String id) {
        orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Заказ не найден"));//todo реализовать ошибку
        orderRepository.deleteById(id);
        return true;
    }

    /**
     * Изменить статус заказа
      * @param orderId заказа
     * @param updateStatus новый статус
     * @return true при успехе
     */
    @Override
    @Transactional
    public boolean changeStatusOrder(String orderId, OrderStatus updateStatus) {
        Order foundOrder = orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException("Заказ не найден"));//todo реализовать ошибку
        foundOrder.setStatus(updateStatus);
        orderRepository.save(foundOrder);
        return true;
    }
}
