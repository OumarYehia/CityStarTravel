package com.citystartravel.backend.entity.bus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BusRequest {

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 10)
    private String platesLetters;

    @NotBlank
    @Size(max = 10)
    private String platesNumbers;

    public BusRequest() {}

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
}
