package com.citystarstourseg.backend.DAOs;

public class SparePartsLegendItem {

    private String spareTypeID, spareTypeName;
    private int quantityAvailable, quantityAllocated;

    public SparePartsLegendItem(String spareTypeID, String spareTypeName, int quantityAvailable, int quantityAllocated) {

        this.spareTypeID = spareTypeID;
        this.spareTypeName = spareTypeName;
        this.quantityAvailable = quantityAvailable;
        this.quantityAllocated = quantityAllocated;
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

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityAllocated() {
        return quantityAllocated;
    }

    public void setQuantityAllocated(int quantityAllocated) {
        this.quantityAllocated = quantityAllocated;
    }
}
