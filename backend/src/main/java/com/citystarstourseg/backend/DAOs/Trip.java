package com.citystarstourseg.backend.DAOs;

import java.time.LocalDate;

public class Trip {

    private String id, destination,client, serialNumber, driverName, busName, orderID;
    private double kmStart, kmEnd,price_basePrice,price_taxes,price_tips,price_tolls,price_repairs;
    private int driverID,busID,capacity;
    private LocalDate tripDate;

    public Trip(String id, String destination, String client, String serialNumber, double kmStart, double kmEnd, double basePrice, double taxes, double tips, double tolls, double repairs, int driverID, int busID, int capacity,LocalDate tripDate) {
        this.id = id;
        this.destination = destination;
        this.client = client;
        this.serialNumber = serialNumber;
        this.kmStart = kmStart;
        this.kmEnd = kmEnd;
        this.price_basePrice=basePrice;
        this.price_taxes=taxes;
        this.price_tips=tips;
        this.price_tolls=tolls;
        this.price_repairs=repairs;
        this.driverID=driverID;
        this.busID=busID;
        this.capacity=capacity;
        this.tripDate = tripDate;
    }

    public Trip(String destination, String client, String serialNumber, double kmStart, double kmEnd, double basePrice, double taxes, double tips, double tolls, double repairs, int driverID, int busID, int capacity, LocalDate tripDate) {
        this.destination = destination;
        this.client = client;
        this.serialNumber = serialNumber;
        this.kmStart = kmStart;
        this.kmEnd = kmEnd;
        this.price_basePrice=basePrice;
        this.price_taxes=taxes;
        this.price_tips=tips;
        this.price_tolls=tolls;
        this.price_repairs=repairs;
        this.driverID=driverID;
        this.busID=busID;
        this.capacity=capacity;
        this.tripDate = tripDate;
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

    public String getDriverName() {
        return driverName;
    }

    public String getBusName() {
        return busName;
    }

    public String getOrderID() {
        return orderID;
    }

    public double getKmStart() {
        return kmStart;
    }

    public double getKmEnd() {
        return kmEnd;
    }

    public double getPrice_basePrice() {
        return price_basePrice;
    }

    public double getPrice_taxes() {
        return price_taxes;
    }

    public double getPrice_tips() {
        return price_tips;
    }

    public double getPrice_tolls() {
        return price_tolls;
    }

    public double getPrice_repairs() {
        return price_repairs;
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

    public LocalDate getTripDate() {
        return tripDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setId(String id) {
        this.id = id;
    }

}
