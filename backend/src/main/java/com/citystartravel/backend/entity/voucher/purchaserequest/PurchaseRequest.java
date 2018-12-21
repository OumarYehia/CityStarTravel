package com.citystartravel.backend.entity.voucher.purchaserequest;

import com.citystartravel.backend.entity.voucher.Voucher;
import com.citystartravel.backend.entity.voucher.item.VoucherItem;
import com.citystartravel.backend.entity.voucher.stockreceived.StockReceived;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
//@DiscriminatorValue("purchaserequest")
public class PurchaseRequest extends Voucher {

    private String needsRequest;

    private String address;

    @OneToMany(
            mappedBy = "voucher",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private List<VoucherItem> voucherItems = new ArrayList<>();

    @OneToMany(
            mappedBy = "purchaseRequest",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private List<StockReceived> stockReceivedList = new ArrayList<>();

    public PurchaseRequest() { super();}


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

    public List<StockReceived> getStockReceivedList() {
        return stockReceivedList;
    }

    public void setStockReceivedList(List<StockReceived> stockReceivedList) {
        this.stockReceivedList.retainAll(stockReceivedList);
        this.stockReceivedList.addAll(stockReceivedList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseRequest voucher = (PurchaseRequest) o;
        return Objects.equals(this.getId(), voucher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
