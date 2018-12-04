package com.citystartravel.backend.entity.spare;

import com.citystartravel.backend.entity.sparetype.SpareType;

public class SpareRequest {

    private SpareType spareType;

    private String name;

    private int quantity;

    public SpareRequest() {}

    public SpareRequest(SpareType spareType, int quantity) {
        this.spareType = spareType;
        this.quantity = quantity;
    }

    public SpareRequest(SpareType spareType, String name, int quantity) {
        this.spareType = spareType;
        this.name = name;
        this.quantity = quantity;
    }

    public SpareType getSpareType() {
        return spareType;
    }

    public void setSpareType(SpareType spareType) {
        this.spareType = spareType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
