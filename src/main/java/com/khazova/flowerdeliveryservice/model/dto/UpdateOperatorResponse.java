package com.khazova.flowerdeliveryservice.model.dto;

public class UpdateOperatorResponse {
    boolean updated;

    public UpdateOperatorResponse(boolean updated) {
        this.updated = updated;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
}
