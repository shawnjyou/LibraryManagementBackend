package com.example.librarymanagement.request;

import com.example.librarymanagement.model.InventoryStatus;

public class InventoryStatusUpdateRequest {
    private InventoryStatus status;

    public InventoryStatus getStatus() {
        return status;
    }

    public void setStatus(InventoryStatus status) {
        this.status = status;
    }
}
