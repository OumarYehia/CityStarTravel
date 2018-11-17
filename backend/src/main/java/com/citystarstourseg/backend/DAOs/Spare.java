package com.citystarstourseg.backend.DAOs;

public class Spare {

    private String spareID, spareName, spareTypeID, spareTypeName, busID, busName, orderID;
    private int quantity;

    public Spare() {}

    public Spare(String spareName, String spareTypeID, String busID, String orderID) {
        this.spareName = spareName;
        this.spareTypeID = spareTypeID;
        this.busID = busID;
        this.orderID = orderID;
    }

    public Spare(String spareID, String spareName, String spareTypeID,
                 String spareTypeName, String busID, String busName, String orderID) {
        this.spareID = spareID;
        this.spareName = spareName;
        this.spareTypeID = spareTypeID;
        this.spareTypeName = spareTypeName;
        this.busID = busID;
        this.busName = busName;
        this.orderID = orderID;
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

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
