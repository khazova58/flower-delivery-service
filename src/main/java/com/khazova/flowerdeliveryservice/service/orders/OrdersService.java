package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.DTO.OrderDTO;

import java.util.List;

public interface OrdersService {
    /**
     * Создание нового заказа
     *
     * @param order заказ
     * @return execution message
     */
    String newOrder(OrderDTO order);

    /**
     * Возвращает все заказы
     *
     * @return list - список заказов
     */
    List<OrderDTO> allOrder();

    /**
     * Возвращает заказ клиента по ID
     *
     * @param id
     * @return list заказов клиента
     */
    List<OrderDTO> getOrderByIDClient(int id);

    /**
     * Редактирование заказа по ID
     *
     * @param id заказа
     * @return execution message
     */
    String updateOrder(int id);

    /**
     * Удаление заказа по ID
     *
     * @param id заказа
     * @return execution message
     */
    String deleteOrder(int id);
}
