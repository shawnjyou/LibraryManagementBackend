package com.example.librarymanagement.model;

public enum InventoryStatus {

    AVAILABLE("在庫"),
    ON_LOAN("出借中"),
    PROCESSING("整理中(歸還後未入庫)"),
    LOST("遺失"),
    DAMAGED("損毀"),
    DISPOSED("廢棄");

    private final String status;

    InventoryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
