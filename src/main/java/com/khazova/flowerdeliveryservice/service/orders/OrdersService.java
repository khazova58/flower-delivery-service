package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.DTO.ClientDTO;
import com.khazova.flowerdeliveryservice.model.DTO.CourierDTO;
import com.khazova.flowerdeliveryservice.model.DTO.OrderDTO;

import java.util.List;

public interface OrdersService {
    /**
     * Создание нового заказа
     *
     * @param dto
     * @return execution message
     */
    String newOrder(OrderDTO dto);

    /**
     * Возвращает все заказы
     *
     * @return list - список заказов
     */
    List<OrderDTO> findAllOrder();

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
    boolean updateOrder(int id);

    /**
     * Удаление заказа по ID
     *
     * @param id заказа
     * @return execution message
     */
    boolean deleteOrder(int id);
}
