package com.khazova.flowerdeliveryservice.exception.part2;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    COURIER_NOT_FOUND("Error:0101", "Курьер с id '%s' не найден", HttpStatus.NOT_FOUND),
    CLIENT_NOT_FOUND("Error:0102", "Клиент с id '%s' не найден", HttpStatus.NOT_FOUND),
    ORDER_NOT_FOUND("Error:0103", "Заказ с id '%s' не найден", HttpStatus.NOT_FOUND),
    EMAIL_EXIST("Error:0104", "Email '%s' уже существует", HttpStatus.METHOD_NOT_ALLOWED);

    private final String errorCode;
    private final String description;
    private final HttpStatus httpStatus;

    Error(String errorCode, String description, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
