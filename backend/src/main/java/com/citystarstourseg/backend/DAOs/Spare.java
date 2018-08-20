package com.citystarstourseg.backend.DAOs;

public class Spare {

    private String spareID, spareName, spareTypeID, busID;

    public Spare(String spareName, String spareTypeID, String busID) {
        this.spareName = spareName;
        this.spareTypeID = spareTypeID;
        this.busID = busID;
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

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }
}
