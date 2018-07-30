package com.citystarstourseg.backend.Services;


public class HelloWorldService {

    private final long id;
    private final String content;

    public HelloWorldService(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
