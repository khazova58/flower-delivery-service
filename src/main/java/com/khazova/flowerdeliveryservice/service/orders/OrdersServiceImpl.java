package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.entity.Client;
import com.khazova.flowerdeliveryservice.model.entity.Courier;
import com.khazova.flowerdeliveryservice.model.entity.Order;
import com.khazova.flowerdeliveryservice.repository.ClientRepository;
import com.khazova.flowerdeliveryservice.repository.CourierRepository;
import com.khazova.flowerdeliveryservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrdersServiceImpl implements OrdersService {

    private final OrderRepository repository;
    private final ClientRepository clientRepository;
    private final CourierRepository courierRepository;

    public OrdersServiceImpl(OrderRepository repository, ClientRepository clientRepository, CourierRepository courierRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.courierRepository = courierRepository;
    }

    @Override
    @Transactional
    public String newOrder(OrderDto dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));
        Courier courier = courierRepository.findById(dto.getCourierId()).orElseThrow(() -> new RuntimeException("Courier not found"));
        Order order = new Order(courier, client, dto.getAddressClient(), dto.getAddressDelivery());
        repository.save(order);
        return "Заказ: " + order.getOrderID() + " разместил клиент: " + order.getClient().getClientId();
    }

    @Override
    public List<OrderDto> findAllOrder() {
        return null;
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
