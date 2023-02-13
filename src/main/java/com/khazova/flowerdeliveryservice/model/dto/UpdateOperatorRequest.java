package com.khazova.flowerdeliveryservice.model.dto;

public class UpdateOperatorRequest {
    private String id;
    private OperatorDTO data;
    public UpdateOperatorRequest() {
    }
    public UpdateOperatorRequest(String id, OperatorDTO data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OperatorDTO getData() {
        return data;
    }

    public void setData(OperatorDTO data) {
        this.data = data;
    }
}