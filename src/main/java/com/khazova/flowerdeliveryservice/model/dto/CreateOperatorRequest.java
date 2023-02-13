package com.khazova.flowerdeliveryservice.model.dto;

public class CreateOperatorRequest {
    private OperatorDTO data;

    public CreateOperatorRequest() {
    }

    public CreateOperatorRequest(OperatorDTO data) {
        this.data = data;
    }

    public OperatorDTO getData() {
        return data;
    }

    public void setData(OperatorDTO data) {
        this.data = data;
    }
}
