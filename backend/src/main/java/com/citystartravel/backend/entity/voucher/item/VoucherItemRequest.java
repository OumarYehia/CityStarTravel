package com.citystartravel.backend.entity.voucher.item;

import com.citystartravel.backend.entity.sparetype.SpareType;
import com.citystartravel.backend.entity.voucher.purchaserequestvoucher.PurchaseRequestVoucher;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class VoucherItemRequest {

    @NotBlank
    private long spareTypeID;

    private String description;

    private String unit;

    @Min(value = 1)
    private int quantity;

    private String notes;

    public VoucherItemRequest() {}

    public VoucherItemRequest(long spareTypeID, String description, String unit, @Min(value = 1) int quantity, String notes) {
        this.spareTypeID = spareTypeID;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
        this.notes = notes;
    }

    public long getSpareTypeID() {
        return spareTypeID;
    }

    public void setSpareTypeID(long spareType) {
        this.spareTypeID = spareType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
