package com.citystartravel.backend.entity.voucher.purchaserequest;

import com.citystartravel.backend.entity.sparetype.SpareTypeService;
import com.citystartravel.backend.entity.voucher.item.VoucherItem;
import com.citystartravel.backend.entity.voucher.item.VoucherUtility;
import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.Mapper;
import com.citystartravel.backend.util.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* ------------------------ PRV: Purchase Request Voucher ------------------------ */
@Service
public class PurchaseRequestService {
    
    @Autowired
    private PurchaseRequestRepository purchaseRequestRepository;

    @Autowired
    private Mapper<PurchaseRequestDtoRequest, PurchaseRequest> mapper;

    @Autowired
    private VoucherUtility voucherUtility;

    @Autowired
    private SpareTypeService spareTypeService;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseRequestService.class);

    private UtilityMethods<PurchaseRequest> utilityMethods = new UtilityMethods<>();

    public PagedResponse<PurchaseRequest> getAllPurchaseRequestVouchers(UserPrincipal currentUser, int page, int size) {
        return utilityMethods.getAll(purchaseRequestRepository,currentUser,page,size);
    }

    public PurchaseRequest getPurchaseRequestVoucherById(Long purchaseRequestVoucherId, @CurrentUser UserPrincipal currentUser) {
        return utilityMethods.getById(purchaseRequestRepository, currentUser, purchaseRequestVoucherId,"PurchaseRequest");
    }

    public PurchaseRequest createPurchaseRequestVoucher(PurchaseRequestDtoRequest purchaseRequestDtoRequest, @CurrentUser UserPrincipal currentUser) {
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest = purchaseRequestRepository.save(purchaseRequest); // creates a new Purchase Request Voucher in the database to attach it to Voucher Item
        purchaseRequest = mapPRVToPRVRequest(purchaseRequestDtoRequest, purchaseRequest, currentUser);

        String eventLog = utilityMethods.generateEntityCreationMessage("PurchaseRequest",String.valueOf(purchaseRequest.getId()),currentUser);
        logger.info(eventLog);

        return purchaseRequestRepository.save(purchaseRequest);
    }

    public PurchaseRequest updatePurchaseRequestVoucher(PurchaseRequest purchaseRequest) {
        return utilityMethods.update(purchaseRequestRepository, purchaseRequest);
    }

    public void deletePurchaseRequestVoucher(PurchaseRequest purchaseRequest) {
        utilityMethods.delete(purchaseRequestRepository, purchaseRequest);
    }

    // ---------------------------------- util ----------------------------------

    private PurchaseRequest mapPRVToPRVRequest(PurchaseRequestDtoRequest request, PurchaseRequest purchaseRequest, @CurrentUser UserPrincipal currentUser) {
        // creates new PRV from PRVRequest
        mapper.mapEntityToDto(request, purchaseRequest);
        // handle voucher items
        List<VoucherItem> voucherItems = voucherUtility.getVoucherItemsFromRequest(request, currentUser, purchaseRequest);
        purchaseRequest.setVoucherItems(voucherItems);
        return purchaseRequest;
    }


}
