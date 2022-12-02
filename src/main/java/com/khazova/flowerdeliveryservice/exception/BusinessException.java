package com.khazova.flowerdeliveryservice.exception;


public abstract class BusinessException extends RuntimeException {

    public abstract String getError();

    public abstract String getDescription();

}