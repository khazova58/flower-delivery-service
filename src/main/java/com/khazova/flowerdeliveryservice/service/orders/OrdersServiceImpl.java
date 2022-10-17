package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.DTO.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Override
    public String newOrder(OrderDTO order) {
        return null;
    }

    @Override
    public List<OrderDTO> allOrder() {
        return null;
    }

    @Override
    public List<OrderDTO> getOrderByIDClient(int id) {
        return null;
    }

    @Override
    public String updateOrder(int id) {
        return null;
    }

    @Override
    public String deleteOrder(int id) {
        return null;
    }
}
