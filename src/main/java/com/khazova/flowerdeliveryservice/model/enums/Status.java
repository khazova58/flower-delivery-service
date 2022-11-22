package com.khazova.flowerdeliveryservice.model.enums;

/**
 * Статусная модель для Заказа
 */
public enum Status {
    CREATED,//создан
    UNDERWAY,//в работе
    PAYMENT,//оплачен
    DELIVERED,//доставлен
    ARCHIVE//архив
}

