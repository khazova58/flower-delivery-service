package com.khazova.flowerdeliveryservice.service.orders;

import com.khazova.flowerdeliveryservice.model.dto.OrderDto;
import com.khazova.flowerdeliveryservice.model.dto.OrderDtoToFind;
import com.khazova.flowerdeliveryservice.model.dto.OrderDtoToNew;

import java.util.List;

public interface OrdersService {
    /**
     * Создание нового заказа (принимает объект класса DTO, возвращает сообщение о выполнении)
     *
     * @param dto представление таблицы Orders
     * @return execution message
     */
    OrderDtoToNew newOrder(OrderDto dto);

    /**
     * Возвращает все заказы
     *
     * @return list - список заказов
     */
    List<OrderDtoToFind> findAllOrder();

    /**
     * Возвращает заказ клиента по ID
     *
     * @param id идентификатор клиента
     * @return list заказов клиента
     */
    List<OrderDto> getOrderByIDClient(int id);

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
