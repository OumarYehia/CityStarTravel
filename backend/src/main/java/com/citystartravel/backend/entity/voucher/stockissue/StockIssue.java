package com.citystartravel.backend.entity.voucher.stockissue;

import com.citystartravel.backend.entity.bus.Bus;
import com.citystartravel.backend.entity.voucher.Voucher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StockIssue extends Voucher {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bus_id")
    @JsonBackReference
    private Bus bus;

    public StockIssue() {}

    public StockIssue(Bus bus) {
        this.bus = bus;
    }

    public Bus getBus() {
        return bus;
    }

    @JsonIgnore
    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
