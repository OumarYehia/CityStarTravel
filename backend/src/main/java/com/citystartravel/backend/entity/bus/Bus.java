package com.citystartravel.backend.entity.bus;

import com.citystartravel.backend.config.audit.DateAudit;
import com.citystartravel.backend.config.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buses", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        })
})
public class Bus extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 10)
    private String platesLetters;

    @NotBlank
    @Size(max = 10)
    private String platesNumbers;


    @Size(max = 25)
    private String status;

    @Size(max = 25)
    private String busCondition;

    @OneToMany(
            mappedBy = "bus",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<BusEvent> events = new ArrayList<>();

/*    @OneToMany(
            mappedBy = "bus",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<SparePart> spareParts = new ArrayList<>();*/

    public Bus() {}

    public Bus(@NotBlank @Size(max = 20) String name, @NotBlank @Size(max = 10) String platesLetters, @NotBlank @Size(max = 10) String platesNumbers, @Size(max = 25) String status, @Size(max = 25) String busCondition) {
        this.name = name;
        this.platesLetters = platesLetters;
        this.platesNumbers = platesNumbers;
        this.status = status;
        this.busCondition = busCondition;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusCondition() {
        return busCondition;
    }

    public void setBusCondition(String busCondition) {
        this.busCondition = busCondition;
    }

    public List<BusEvent> getEvents() {
        return events;
    }

    public void setEvents(List<BusEvent> events) {
        this.events = events;
    }

    public void addBusEvent(BusEvent busEvent) {
        events.add(busEvent);
        busEvent.setBus(this);
    }

    public void removeBusEvent(BusEvent busEvent) {
        events.remove(busEvent);
        busEvent.setBus(null);
    }
}
