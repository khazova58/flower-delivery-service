package com.khazova.flowerdeliveryservice.model.dto;

import javax.validation.Valid;

public class CreateOperatorRequest {
    @Valid private OperatorDTO data;

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
