package com.citystartravel.backend.entity.bus.event;

public class BusEventRequest {

    private long id;

    private String text;

    private String busCondition;

    private boolean resolved;

    private BusEventType busEventType;

    public BusEventRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBusCondition() {
        return busCondition;
    }

    public void setBusCondition(String busCondition) {
        this.busCondition = busCondition;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public BusEventType getBusEventType() {
        return busEventType;
    }

    public void setBusEventType(BusEventType busEventType) {
        this.busEventType = busEventType;
    }
}
