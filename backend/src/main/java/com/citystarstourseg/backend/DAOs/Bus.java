package com.citystarstourseg.backend.DAOs;

public class Bus {

    private String id, name, platesAlpha, platesNum, make;

    public Bus(String id, String name, String platesAlpha, String platesNum, String make) {
        this.id = id;
        this.name = name;
        this.platesAlpha = platesAlpha;
        this.platesNum = platesNum;
        this.make = make;
    }

    public Bus(String name, String platesAlpha, String platesNum, String make) {
        this.name = name;
        this.platesAlpha = platesAlpha;
        this.platesNum = platesNum;
        this.make = make;
    }

    public Bus(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlatesAlpha() {
        return platesAlpha;
    }

    public String getPlatesNum() {
        return platesNum;
    }

    public String getMake() {
        return make;
    }

    public void setId(String id) {
        this.id = id;
    }
}
