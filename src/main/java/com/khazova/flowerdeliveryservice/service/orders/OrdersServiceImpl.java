package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.exception.Error;
import com.khazova.flowerdeliveryservice.exception.ServiceException;
import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.dto.RequestForClientDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import com.khazova.flowerdeliveryservice.model.mapper.OrderMapper;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import com.khazova.flowerdeliveryservice.repository.CourierRepository;
import com.khazova.flowerdeliveryservice.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

    private Client getClient(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new ServiceException(Error.CLIENT_NOT_FOUND, id));
    }

    /**
     * Создать новый заказ
     *
     * @param dto представление таблицы Orders
     * @return сохраненный заказ
     */
    @Override
    @Transactional
    public NewOrderDto newOrder(OrderDto dto) {
        String id = dto.getClientId();
        Client newClient = getClient(id);
        Order order = new Order(newClient, dto.getAddressClient(), dto.getAddressDelivery());
        Order save = orderRepository.save(order);
        return mapper.entityMapToNewDto(save);
    }

    /**
     * Поиск всех заказов
     *
     * @return список заказов, отсортированный по дате создания (новые->старые)
     */
    @Override
    public List<FindOrderDto> findAllOrders(Pageable pageable) {
        Page<Order> foundOrders = orderRepository.findAll(pageable);
        return foundOrders.stream()
                .map(order -> mapper.entityMapToFindDto(order))
                .toList();
    }

    /**
     * Поиск заказов по клиенту
     *
     * @param request объект запроса
     * @return список найденных заказов отсортированный по возрастанию
     */
    @Override
    public List<FindOrderDto> getOrdersByClientWithParam(@RequestBody RequestForClientDto request, Sort sort) {
        Client foundClient = getClient(request.getClientId());
        List<Order> foundOrders = orderRepository.findOrdersByRequest(foundClient.getClientId(), request.getStatus(), request.getStartDate(), request.getEndDate(), sort);
        return foundOrders.stream()
                .map(order -> mapper.entityMapToFindDto(order))
                .toList();
    }

    /**
     * Поиск заказов по курьеру
     *
     * @param courierId идентификатор курьера
     * @return список найденных заказов
     */
    @Override
    public List<FindOrderDto> getOrderByCourierId(String courierId) {
        Courier foundCourier = courierRepository.findById(courierId).orElseThrow(() -> new ServiceException(Error.COURIER_NOT_FOUND, courierId));
        List<Order> foundOrders = orderRepository.findOrdersByCourier(foundCourier);
        return foundOrders.stream()
                .map(order -> mapper.entityMapToFindDto(order))
                .toList();
    }

    /**
     * Удаление заказа
     *
     * @param id заказа
     * @return true в случае успеха
     */
    @Override
    @Transactional
    public boolean deleteOrder(String id) {
        getOrder(id);
        orderRepository.deleteById(id);
        return true;
    }

    /**
     * Изменить статус заказа
     *
     * @param orderId      заказа
     * @param updateStatus новый статус
     * @return true при успехе
     */
    @Override
    @Transactional
    public boolean changeStatusOrder(String orderId, OrderStatus updateStatus) {
        Order foundOrder = getOrder(orderId);
        foundOrder.setStatus(updateStatus);
        orderRepository.save(foundOrder);
        return true;
    }

    /**
     * Проверка наличия заказа с указанным id
     *
     * @param orderId заказа
     * @return заказ или сообщение об ошибке
     */
    private Order getOrder(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new ServiceException(Error.ORDER_NOT_FOUND, orderId));
    }
}
