package com.citystartravel.backend.entity.voucher.stockreceived;

import com.citystartravel.backend.entity.voucher.VoucherDto;

public class StockReceivedDtoRequest extends VoucherDto {

    private long purchaseOrder;

    public StockReceivedDtoRequest() {}

    public long getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(long purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
