package com.khazova.flowerdeliveryservice.exception.part1;

public class CourierNotFoundException extends BusinessException {

    private static final String ERROR_CODE = "Error:0102";
    private static final String MESSAGE = "Курьер с id '%s' не найден";
    private final String courierId;

    public CourierNotFoundException(String id) {
        this.courierId = id;
    }

    @Override
    public String getError() {
        return ERROR_CODE;
    }

    @Override
    public String getDescription() {
        return MESSAGE.formatted(courierId);
    }
}