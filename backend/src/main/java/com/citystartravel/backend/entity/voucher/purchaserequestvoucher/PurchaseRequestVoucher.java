package com.citystartravel.backend.entity.voucher.purchaserequestvoucher;

import com.citystartravel.backend.config.audit.UserDateAudit;
import com.citystartravel.backend.entity.voucher.item.VoucherItem;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "purchaserequestvouchers")
public class PurchaseRequestVoucher extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long serialNo;

    private String supplierCode;

    private String supplierName;

    private String needsRequest;

    private String address;

    @OneToMany(
            mappedBy = "purchaseRequestVoucher",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private List<VoucherItem> voucherItems = new ArrayList<>();


    public PurchaseRequestVoucher() {}

    public PurchaseRequestVoucher(String supplierName) {
        this.supplierName = supplierName;
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

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<VoucherItem> getVoucherItems() {
        return voucherItems;
    }

    public void setVoucherItems(List<VoucherItem> voucherItems) {
        this.voucherItems.retainAll(voucherItems);
        this.voucherItems.addAll(voucherItems);
    }

    void addVoucherItem(VoucherItem voucherItem) {
        voucherItems.add(voucherItem);
        voucherItem.setPurchaseRequestVoucher(this);
    }

    void removeVoucherItem(VoucherItem voucherItem) {
        voucherItems.remove(voucherItem);
        voucherItem.setPurchaseRequestVoucher(null);
    }

    public String getNeedsRequest() {
        return needsRequest;
    }

    public void setNeedsRequest(String needsRequest) {
        this.needsRequest = needsRequest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseRequestVoucher voucher = (PurchaseRequestVoucher) o;
        return Objects.equals(id, voucher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
