package com.citystartravel.backend.entity.voucher.item;

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
    private Mapper<VoucherItemRequest, VoucherItem> mapper_VIR_VI;

    /*
     * This method creates new entity voucher items based on details specified in the VoucherItemRequest
     * @param purchaseRequestVoucherRequest: Voucher Request Received
     */
    /*public List<VoucherItem> CreateVoucherItemsFromRequest(PurchaseRequestVoucherRequest purchaseRequestVoucherRequest) {

        // TODO: DEBUG
        List<VoucherItemRequest> voucherItemRequests = purchaseRequestVoucherRequest.getVoucherItemRequests();
        List<VoucherItem> voucherItems = new ArrayList<>();
        if(voucherItemRequests != null) {
            for(VoucherItemRequest voucherItemRequest : voucherItemRequests) {
                VoucherItem voucherItem = new VoucherItem();

                voucherItem.setSpareType(
                        spareTypeRepository.getOne(voucherItemRequest.getSpareTypeID())
                );
                voucherItem.setQuantity(voucherItemRequest.getQuantity());
                voucherItems.add(voucherItem);
            }
        }
        return voucherItems;
    }*/

    // ---------------------------------- util ----------------------------------
    private VoucherItem mapVIRequestToVI(VoucherItemRequest voucherItemRequest, UserPrincipal currentUser) {
        VoucherItem voucherItem = mapper_VIR_VI.mapEntityToDto(voucherItemRequest,VoucherItem.class);
        voucherItem.setSpareType(spareTypeService.getSpareTypeById(voucherItemRequest.getSpareTypeID(), currentUser));
        return voucherItem;
    }


}
