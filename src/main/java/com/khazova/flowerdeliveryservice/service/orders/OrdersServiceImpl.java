package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import com.khazova.flowerdeliveryservice.model.mapper.OrderMapper;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
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
    private final OrderMapper mapper;

    public OrdersServiceImpl(OrderRepository repository, ClientRepository clientRepository, OrderMapper mapper) {
        this.orderRepository = repository;
        this.clientRepository = clientRepository;
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
        List<Order> findOrders = orderRepository.findAll();
        List<FindOrderDto> dtoFind = new ArrayList<>();
        for (Order order : findOrders) {
            dtoFind.add(mapper.entityMapToFindDto(order));
        }
        return dtoFind;
    }

    /**
     * Поиск заказов по клиенту
     * @param clientId идентификатор клиента
     * @return список найденных заказов
     */
    @Override
    public List<FindOrderDto> getOrdersByClientId(String clientId) {
        List<Order> findOrders = orderRepository.findOrdersByClient_ClientId(clientId);
        List<FindOrderDto> dtoFind = new ArrayList<>();
        for (Order order : findOrders) {
            dtoFind.add(mapper.entityMapToFindDto(order));
        }
        return dtoFind;
    }

    /**
     * Поиск заказов по курьеру
     * @param courierId идентификатор курьера
     * @return список найденных заказов
     */
    @Override
    public List<FindOrderDto> getOrderByIdCourier(String courierId) {
        List<Order> findOrders = orderRepository.findOrdersByCourier_CourierId(courierId);
        List<FindOrderDto> dtoFind = new ArrayList<>();
        for (Order order : findOrders) {
            dtoFind.add(mapper.entityMapToFindDto(order));
        }
        return dtoFind;
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
        Order findOrder = orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException("Заказ не найден"));//todo реализовать ошибку
        findOrder.setStatus(updateStatus);
        orderRepository.save(findOrder);
        return true;
    }
}
