package com.khazova.flowerdeliveryservice.model.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATED("Создано", false),
    UNDERWAY("Принято в работу", false),
    DELIVERED("Передано в доставку", false),
    RECEIVED("Получено", true);

    private final String description;
    private final boolean isFinal;

    OrderStatus(String description, boolean isFinal) {
        this.description = description;
        this.isFinal = isFinal;
    }
}

