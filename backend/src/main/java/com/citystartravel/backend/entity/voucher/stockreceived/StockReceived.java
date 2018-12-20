package com.citystartravel.backend.entity.voucher.stockreceived;

import com.citystartravel.backend.entity.voucher.Voucher;
import com.citystartravel.backend.entity.voucher.item.VoucherItem;
import com.citystartravel.backend.entity.voucher.purchaserequest.PurchaseRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
//@DiscriminatorValue("stockreceived")
public class StockReceived extends Voucher {

    private String deliveryNote;

    private String supplierInvoice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="purchase_request_id", nullable = false)
    @JsonBackReference
    private PurchaseRequest purchaseRequest;

    @OneToMany(
            mappedBy = "voucher",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private List<VoucherItem> voucherItems = new ArrayList<>();


    public StockReceived() {}

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
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
        voucherItem.setVoucher(this);
    }

    void removeVoucherItem(VoucherItem voucherItem) {
        voucherItems.remove(voucherItem);
        voucherItem.setVoucher(null);
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public String getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(String supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockReceived voucher = (StockReceived) o;
        return Objects.equals(this.getId(), voucher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
