package com.citystarstourseg.backend.DAOs;

public class SimplePostRequestBody {

    private String id;

    public SimplePostRequestBody(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
