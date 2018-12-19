package com.citystartravel.backend.entity.voucher.item;

import com.citystartravel.backend.entity.sparetype.SpareType;
import com.citystartravel.backend.entity.sparetype.SpareTypeService;
import com.citystartravel.backend.entity.voucher.Voucher;
import com.citystartravel.backend.entity.voucher.VoucherDto;
import com.citystartravel.backend.entity.voucher.purchaserequest.PurchaseRequestDtoRequest;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoucherUtility {

    @Autowired
    private SpareTypeService spareTypeService;

    @Autowired
    private VoucherItemRepository voucherItemRepository;

    @Autowired
    private Mapper<VoucherItemRequest, VoucherItem> mapper_VIR_VI;

    public List<VoucherItem> getVoucherItemsFromRequest(VoucherDto dto,
                                                        UserPrincipal currentUser,
                                                        Voucher voucher) {
        List<VoucherItemRequest> voucherItemRequests = dto.getVoucherItemRequests();
        List<VoucherItem> voucherItems = new ArrayList<>();
        SpareType spareType;
        for(VoucherItemRequest voucherItemRequest : voucherItemRequests) {
            VoucherItem voucherItem = mapper_VIR_VI.mapEntityToDto(voucherItemRequest, VoucherItem.class);
            spareType = spareTypeService.getSpareTypeById(voucherItemRequest.getSpareTypeID(), currentUser);
            voucherItem.setSpareType(spareType);
            voucherItem.setVoucher(voucher);
            voucherItem = voucherItemRepository.save(voucherItem);
            voucherItems.add(voucherItem);
        }
        return voucherItems;
    }
}
