package com.khazova.flowerdeliveryservice.exception;

public class UserNotFoundException extends BusinessException {

    private static final String ERROR_CODE = "Error:0101";
    private static final String MESSAGE = "Пользователь с id '%s' не найден";
    private final String clientId;

    public UserNotFoundException(String id) {
        this.clientId = id;
    }

    @Override
    public String getError() {
        return ERROR_CODE;
    }

    @Override
    public String getDescription() {
        return MESSAGE.formatted(clientId);
    }
}