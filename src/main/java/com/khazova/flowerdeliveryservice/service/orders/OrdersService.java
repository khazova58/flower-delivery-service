package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.dto.FindOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.NewOrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;

import java.util.List;

public interface OrdersService {
    /**
     * Создание нового заказа (принимает объект класса DTO, возвращает сообщение о выполнении)
     *
     * @param dto представление таблицы Orders
     * @return execution message
     */
    NewOrderDto newOrder(OrderDto dto);

    /**
     * Возвращает все заказы
     *
     * @return list - список заказов
     */
    List<FindOrderDto> findAllOrders();

    /**
     * Возвращает заказы клиента по ID
     *
     * @param clientId идентификатор клиента
     * @return list заказов клиента
     */
    List<FindOrderDto> getOrdersByClientId(String clientId);

    /**
     * Возвращает заказы курьера
     *
     * @param courierId идентификатор курьера
     * @return list заказов курьера
     */
    List<FindOrderDto> getOrderByCourierId(String courierId);

    /**
     * Удаление заказа по ID
     *
     * @param id заказа
     * @return execution message
     */
    boolean deleteOrder(String id);

    /**
     * Изменить статус курьера
     *
     * @param orderId      id заказа
     * @param updateStatus статус
     * @return true в случае успеха
     */
    boolean changeStatusOrder(String orderId, OrderStatus updateStatus);
}
