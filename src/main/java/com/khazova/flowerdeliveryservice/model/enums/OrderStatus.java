package com.khazova.flowerdeliveryservice.model.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATED("Создан", false),
    UNDERWAY("В работе", false),
    PAYMENT("Оплата", false),
    DELIVERED("Доставлен", true),
    ARCHIVE("Архив", true);

    private final String description;
    private final boolean isFinal;

    OrderStatus(String description, boolean isFinal) {
        this.description = description;
        this.isFinal = isFinal;
    }
}

