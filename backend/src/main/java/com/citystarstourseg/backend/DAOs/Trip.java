package com.citystarstourseg.backend.DAOs;

import java.time.LocalDateTime;
import java.util.Date;

public class Trip {

    private String id, destination,serialNumber;
    private double kmStart, kmEnd,basePrice,taxes,tips,tolls,repairs;
    private int driverID,busID,capacity;
    private Date date;
   // private LocalDateTime date;

    public Trip(String id, String destination, String serialNumber, double kmStart, double kmEnd, double basePrice, double taxes, double tips, double tolls, double repairs, int driverID, int busID, int capacity/*, LocalDateTime date*/) {
        this.id = id;
        this.destination = destination;
        this.serialNumber = serialNumber;
        this.kmStart = kmStart;
        this.kmEnd = kmEnd;
        this.basePrice=basePrice;
        this.taxes=taxes;
        this.tips=tips;
        this.tolls=tolls;
        this.repairs=repairs;
        this.driverID=driverID;
        this.busID=busID;
        this.capacity=capacity;
       // this.date=date;



    }

    public Trip(String destination, String serialNumber, double kmStart, double kmEnd, double basePrice, double taxes, double tips, double tolls, double repairs, int driverID, int busID, int capacity/*, LocalDateTime date*/) {
        this.destination = destination;
        this.serialNumber = serialNumber;
        this.kmStart = kmStart;
        this.kmEnd = kmEnd;
        this.basePrice=basePrice;
        this.taxes=taxes;
        this.tips=tips;
        this.tolls=tolls;
        this.repairs=repairs;
        this.driverID=driverID;
        this.busID=busID;
        this.capacity=capacity;
        //this.date=date;
    }

    public Trip(){}

    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getkmStart() {
        return kmStart;
    }

    public double getKmEnd() {
        return kmEnd;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getTaxes() {
        return taxes;
    }

    public double getTips() {
        return tips;
    }

    public double getTolls() {
        return tolls;
    }

    public double getRepairs() {
        return repairs;
    }

    public int getDriverID() {
        return driverID;
    }

    public int getBusID() {
        return busID;
    }

    public int getCapacity() {
        return capacity;
    }

   /* public LocalDateTime getDate() {
        return date;
    }*/


    public void setId(String id) {
        this.id = id;
    }
}
