package com.khazova.flowerdeliveryservice.model.dto;

public class CreateOperatorResponse {
    private String id;

    public CreateOperatorResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
