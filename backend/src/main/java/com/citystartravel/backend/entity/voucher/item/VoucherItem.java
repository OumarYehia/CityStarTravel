package com.citystartravel.backend.entity.voucher.item;

import com.citystartravel.backend.entity.sparetype.SpareType;
import com.citystartravel.backend.entity.voucher.purchaserequestvoucher.PurchaseRequestVoucher;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "voucher_items")
public class VoucherItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long serialNo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="sparetype_id", nullable = false)
    private SpareType spareType;

    private String name;

    private String description;

    private String unit;

    @Min(value = 1)
    private int quantity;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="purchase_request_voucher_id", nullable = false)
    @JsonBackReference
    private PurchaseRequestVoucher purchaseRequestVoucher;

    public VoucherItem() {}

    public VoucherItem(SpareType spareType, String description, String unit, @Min(value = 1) int quantity, String notes) {
        this.spareType = spareType;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
        this.notes = notes;
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

    public SpareType getSpareType() {
        return spareType;
    }

    public void setSpareType(SpareType spareType) {
        this.spareType = spareType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public PurchaseRequestVoucher getPurchaseRequestVoucher() {
        return purchaseRequestVoucher;
    }

    public void setPurchaseRequestVoucher(PurchaseRequestVoucher purchaseRequestVoucher) {
        this.purchaseRequestVoucher = purchaseRequestVoucher;
    }
}
