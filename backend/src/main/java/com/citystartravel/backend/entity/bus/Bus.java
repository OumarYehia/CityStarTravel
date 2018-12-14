package com.citystartravel.backend.entity.bus;

import com.citystartravel.backend.config.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "buses", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        })
})
class Bus extends UserDateAudit {

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

    private boolean inOperation;

    //@Size(max = 4)
    private int busCondition;

    private long km;

    @OneToMany(
            mappedBy = "bus",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private Set<BusEvent> events = new HashSet<>();

/*    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="bus_busevents",
            joinColumns = @JoinColumn(name="bus_id"),
            inverseJoinColumns = @JoinColumn(name="busevent_id"))
    private Set<BusEvent> events = new HashSet<>();*/

/*    @OneToMany(
            mappedBy = "bus",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<SparePart> spareParts = new ArrayList<>();*/

    Bus() {}

    Bus(@NotBlank @Size(max = 20) String name, @NotBlank @Size(max = 10) String platesLetters, @NotBlank @Size(max = 10) String platesNumbers, boolean inOperation, @Size(max = 4) int busCondition, Set<BusEvent> events, long km) {
        this.name = name;
        this.platesLetters = platesLetters;
        this.platesNumbers = platesNumbers;
        this.inOperation = inOperation;
        this.busCondition = busCondition;
        this.events = events;
        this.km = km;
    }

    /*Healthy bus, in operation and in good condition.*/
    Bus(@NotBlank @Size(max = 20) String name, @NotBlank @Size(max = 10) String platesLetters, @NotBlank @Size(max = 10) String platesNumbers, long km) {
        this.name = name;
        this.platesLetters = platesLetters;
        this.platesNumbers = platesNumbers;
        this.inOperation = true;
        this.busCondition = 4;
        this.km = km;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPlatesLetters() {
        return platesLetters;
    }

    void setPlatesLetters(String platesLetters) {
        this.platesLetters = platesLetters;
    }

    String getPlatesNumbers() {
        return platesNumbers;
    }

    void setPlatesNumbers(String platesNumbers) {
        this.platesNumbers = platesNumbers;
    }

    boolean isInOperation() {
        return inOperation;
    }

    void setInOperation(boolean inOperation) {
        this.inOperation = inOperation;
    }

    int getBusCondition() {
        return busCondition;
    }

    void setBusCondition(int busCondition) {
        this.busCondition = busCondition;
    }

    Set<BusEvent> getEvents() {
        return events;
    }

    void setEvents(Set<BusEvent> events) {
        this.events = events;
    }

    void addBusEvent(BusEvent busEvent) {
        events.add(busEvent);
        busEvent.setBus(this);
    }

    void removeBusEvent(BusEvent busEvent) {
        events.remove(busEvent);
        busEvent.setBus(null);
    }

    long getKm() {
        return km;
    }

    void setKm(long km) {
        this.km = km;
    }

    void addKm(long km) {
        this.km += km;
    }
}
