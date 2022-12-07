package com.khazova.flowerdeliveryservice.exception;

public class EmailExistException extends BusinessException {

    private static final String ERROR_CODE = "Error:0104";
    private static final String MESSAGE = "Пользователь с email '%s' уже существет";
    private final String email;

    public EmailExistException(String email) {
        this.email = email;
    }

    @Override
    public String getError() {
        return ERROR_CODE;
    }

    @Override
    public String getDescription() {
        return MESSAGE.formatted(email);
    }
}