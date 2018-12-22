package com.citystartravel.backend.entity.voucher.item;

import com.citystartravel.backend.entity.sparetype.SpareTypeRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class VoucherItemRequest {

    private SpareTypeRequest spareType;

    private String name;

    private String description;

    private String unit;

    @Min(value = 1)
    private int quantity;

    private String notes;

    public VoucherItemRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpareTypeRequest getSpareType() {
        return spareType;
    }

    public void setSpareType(SpareTypeRequest spareType) {
        this.spareType = spareType;
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
