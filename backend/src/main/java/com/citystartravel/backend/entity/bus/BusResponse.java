package com.citystartravel.backend.entity.bus;

public class BusResponse {

    private Long id;
    private String name;
    private String platesLetters;
    private String platesNumbers;
    private boolean inOperation;
    private String condition;
    //private List<BusEvent> events = new ArrayList<>();
    private long km;

    public BusResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatesLetters() {
        return platesLetters;
    }

    public void setPlatesLetters(String platesLetters) {
        this.platesLetters = platesLetters;
    }

    public String getPlatesNumbers() {
        return platesNumbers;
    }

    public void setPlatesNumbers(String platesNumbers) {
        this.platesNumbers = platesNumbers;
    }

    public boolean isInOperation() {
        return inOperation;
    }

    public void setInOperation(boolean inOperation) {
        this.inOperation = inOperation;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

//    public List<BusEvent> getEvents() {
//        return events;
//    }
//
//    public void setEvents(List<BusEvent> events) {
//        this.events = events;
//    }

    public long getKm() {
        return km;
    }

    public void setKm(long km) {
        this.km = km;
    }
}
