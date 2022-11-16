package com.khazova.flowerdeliveryservice.cucumber;

import org.springframework.stereotype.Component;

@Component
public class Service {

    private final Repo repository;

    public Service(Repo repository) {
        this.repository = repository;
    }

    public String saveHello(String str) {
        String result = repository.save(str);
        return "Привет %s %s";//.formatted(result, str);
    }
}
