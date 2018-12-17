package com.citystartravel.backend.entity.voucher.item;

import com.citystartravel.backend.entity.sparetype.SpareType;
import com.citystartravel.backend.entity.sparetype.SpareTypeRepository;
import com.citystartravel.backend.entity.sparetype.SpareTypeService;
import com.citystartravel.backend.entity.voucher.purchaserequestvoucher.PurchaseRequestVoucher;
import com.citystartravel.backend.entity.voucher.purchaserequestvoucher.PurchaseRequestVoucherRequest;
import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
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

    public List<VoucherItem> getVoucherItemsFromRequest(PurchaseRequestVoucherRequest request,
                                                        UserPrincipal currentUser,
                                                        PurchaseRequestVoucher purchaseRequestVoucher) {
        List<VoucherItemRequest> voucherItemRequests = request.getVoucherItemRequests();
        List<VoucherItem> voucherItems = new ArrayList<>();
        SpareType spareType;
        for(VoucherItemRequest voucherItemRequest : voucherItemRequests) {
            VoucherItem voucherItem = new VoucherItem(voucherItemRequest.getQuantity(), purchaseRequestVoucher);
            voucherItem = mapper_VIR_VI.mapEntityToDto(voucherItemRequest, voucherItem);
            spareType = spareTypeService.getSpareTypeById(voucherItemRequest.getSpareTypeID(), currentUser);
            voucherItem.setSpareType(spareType);
            voucherItem.setPurchaseRequestVoucher(purchaseRequestVoucher);
            voucherItem = voucherItemRepository.save(voucherItem);
            voucherItems.add(voucherItem);
        }
        return voucherItems;
    }
}
