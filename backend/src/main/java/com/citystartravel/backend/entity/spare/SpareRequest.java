package com.citystartravel.backend.entity.spare;

public class SpareRequest {

    private long spareTypeID;

    private String name;

    private int quantity;

    public SpareRequest() {}


    public long getSpareTypeID() {
        return spareTypeID;
    }

    public void setSpareTypeID(long spareType) {
        this.spareTypeID = spareType;
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
