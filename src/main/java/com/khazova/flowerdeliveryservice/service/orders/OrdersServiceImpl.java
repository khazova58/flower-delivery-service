package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Order;
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

    private final OrderRepository repository;
    private final ClientRepository clientRepository;
    private final CourierRepository courierRepository;
    private final OrderMapper mapper;

    public OrdersServiceImpl(OrderRepository repository, ClientRepository clientRepository, CourierRepository courierRepository, OrderMapper mapper) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.courierRepository = courierRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public NewOrderDto newOrder(OrderDto dto) {
        String id = dto.getClientId();
        Client newClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        Order order = new Order(newClient, dto.getAddressClient(), dto.getAddressDelivery());
        Order save = repository.save(order);
        return mapper.entityMapToNewDto(save);
    }

    @Override
    public List<FindOrderDto> findAllOrder() {
        List<Order> findOrders = repository.findAll();
        List<FindOrderDto> dtoFind = new ArrayList<>();
        for (Order order : findOrders) {
            dtoFind.add(mapper.entityMapToFindDto(order));
        }
        return dtoFind;
    }

    @Override
    public List<OrderDto> getOrderByIDClient(int id) {
        return null;
    }

    @Override
    public boolean updateOrder(int id) {
        return true;
    }

    @Override
    public boolean deleteOrder(int id) {
        return true;
    }
}
