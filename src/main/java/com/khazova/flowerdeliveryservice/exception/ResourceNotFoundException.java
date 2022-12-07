package com.khazova.flowerdeliveryservice.exception;

public class ResourceNotFoundException extends BusinessException {

    private static final String ERROR_CODE = "Error:0103";
    private static final String MESSAGE = "Заказ с id '%s' не найден";
    private final String orderId;

    public ResourceNotFoundException(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getError() {
        return ERROR_CODE;
    }

    @Override
    public String getDescription() {
        return MESSAGE.formatted(orderId);
    }
}
