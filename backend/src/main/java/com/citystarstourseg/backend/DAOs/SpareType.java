package com.citystarstourseg.backend.DAOs;

public class SpareType {
    private String spareTypeID, spareType;
    private int spareTypeQuantity;

    public SpareType(String spareType) {
        this.spareType = spareType;
        this.spareTypeQuantity = 0;
    }

    public String getSpareTypeID() {
        return spareTypeID;
    }

    public void setSpareTypeID(String spareTypeID) {
        this.spareTypeID = spareTypeID;
    }

    public String getSpareType() {
        return spareType;
    }

    public void setSpareType(String spareType) {
        this.spareType = spareType;
    }

    public int getSpareTypeQuantity() {
        return spareTypeQuantity;
    }

    public void setSpareTypeQuantity(int spareTypeQuantity) {
        this.spareTypeQuantity = spareTypeQuantity;
    }

}
