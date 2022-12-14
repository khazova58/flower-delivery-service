package com.khazova.flowerdeliveryservice.exception.part1;


public abstract class BusinessException extends RuntimeException {

    public abstract String getError();

    public abstract String getDescription();

}