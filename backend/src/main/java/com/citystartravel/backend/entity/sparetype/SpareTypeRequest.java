package com.citystartravel.backend.entity.sparetype;

public class SpareTypeRequest {

    private String name;

    public SpareTypeRequest() {}

    public SpareTypeRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
