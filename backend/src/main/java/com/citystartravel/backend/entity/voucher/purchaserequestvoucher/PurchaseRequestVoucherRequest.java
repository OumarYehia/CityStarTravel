package com.citystartravel.backend.entity.voucher.purchaserequestvoucher;

import com.citystartravel.backend.config.audit.UserDateAudit;
import com.citystartravel.backend.entity.voucher.VoucherItem;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseRequestVoucherRequest extends UserDateAudit {

    private Date date;

    private String supplierCode;

    private String supplierName;

    private String purchaseOrder;
    private String supplierInvoice;
    private String deliveryNote;
    private String inspectionVoucher;

    private List<VoucherItem> voucherItems = new ArrayList<>();


    public PurchaseRequestVoucherRequest() {
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
        this.voucherItems = voucherItems;
    }
}
