package com.citystartravel.backend.entity.spare;

import com.citystartravel.backend.config.audit.UserDateAudit;
import com.citystartravel.backend.entity.sparetype.SpareType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "spares")
public class Spare extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long serialNo;

    private String name;

    private boolean available = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sparetype_id", nullable = false)
    @JsonBackReference
    private SpareType spareType;

    public Spare() {}

    public Spare(SpareType spareType) {
        this.spareType = spareType;
    }

    public Spare(SpareType spareType, String name) {
        this.name = name;
        this.spareType = spareType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(long serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public SpareType getSpareType() {
        return spareType;
    }

    public void setSpareType(SpareType spareType) {
        this.spareType = spareType;
    }
}
