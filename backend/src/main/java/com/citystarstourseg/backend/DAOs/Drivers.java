package com.citystarstourseg.backend.DAOs;

import java.sql.Driver;

public class Drivers {


    private String id, name;

    public Drivers(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public Drivers(String name) {
        this.name = name;
    }

    public Drivers(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
