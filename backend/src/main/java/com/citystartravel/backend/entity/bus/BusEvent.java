package com.citystartravel.backend.entity.bus;

import com.citystartravel.backend.config.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "busevents")
public class BusEvent extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="bus_id", nullable = false)
    @JsonBackReference
    private Bus bus;

    @NotBlank
    private String text;

    private String busCondition;

    private boolean resolved;

    public BusEvent() {}

    public BusEvent(@NotBlank String text) {
        this.text = text;
    }

    public BusEvent(Bus bus, @NotBlank String text) {
        this.bus = bus;
        this.text = text;
        this.resolved = false;
    }

    public BusEvent(Bus bus, @NotBlank String text, String busCondition) {
        this.bus = bus;
        this.text = text;
        this.busCondition = busCondition;
        this.resolved = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusEvent event = (BusEvent) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
