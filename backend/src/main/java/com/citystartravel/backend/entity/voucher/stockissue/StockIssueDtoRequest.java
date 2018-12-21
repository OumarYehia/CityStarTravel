package com.citystartravel.backend.entity.voucher.stockissue;

import com.citystartravel.backend.entity.voucher.VoucherDto;

public class StockIssueDtoRequest extends VoucherDto {

    private long busID;

    public StockIssueDtoRequest() {}

    public long getBusID() {
        return busID;
    }

    public void setBusID(long busID) {
        this.busID = busID;
    }
}
