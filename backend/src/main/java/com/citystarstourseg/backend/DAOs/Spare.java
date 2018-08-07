package com.citystarstourseg.backend.DAOs;

public class Spare {

    private String id, plates, make;

    public Spare(String id, String plates, String make) {
        this.id = id;
        this.plates = plates;
        this.make = make;
    }

    public Spare(String plates, String make) {
        this.plates = plates;
        this.make = make;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
