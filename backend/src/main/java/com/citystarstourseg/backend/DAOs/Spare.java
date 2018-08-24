package com.citystarstourseg.backend.DAOs;

public class Spare {

    private String spareID, spareName, spareTypeID, spareTypeName, busID, busName;
    private int quantity;

    public Spare(String spareName, String spareTypeID, String busID) {
        this.spareName = spareName;
        this.spareTypeID = spareTypeID;
        this.busID = busID;
    }

    public Spare(String spareID, String spareName, String spareTypeID,
                 String spareTypeName, String busID, String busName, int quantity) {
        this.spareID = spareID;
        this.spareName = spareName;
        this.spareTypeID = spareTypeID;
        this.spareTypeName = spareTypeName;
        this.busID = busID;
        this.busName = busName;
        this.quantity = quantity;
    }

    public String getSpareID() {
        return spareID;
    }

    public void setSpareID(String spareID) {
        this.spareID = spareID;
    }

    public String getSpareName() {
        return spareName;
    }

    public void setSpareName(String spareName) {
        this.spareName = spareName;
    }

    public String getSpareTypeID() {
        return spareTypeID;
    }

    public void setSpareTypeID(String spareTypeID) {
        this.spareTypeID = spareTypeID;
    }

    public String getSpareTypeName() {
        return spareTypeName;
    }

    public void setSpareTypeName(String spareTypeName) {
        this.spareTypeName = spareTypeName;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getBusName() {
        return busName;
    }

    public int getQuantity() {
        return quantity;
    }
}
