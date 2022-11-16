package com.khazova.flowerdeliveryservice.cucumber;

import org.springframework.stereotype.Repository;

@Repository
public class Repo {


    public String save(String str) {

        return str != null
                ? "сохраненный"
                : "несохраненный";
    }
}
