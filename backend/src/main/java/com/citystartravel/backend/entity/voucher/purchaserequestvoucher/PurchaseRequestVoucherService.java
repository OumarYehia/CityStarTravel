package com.citystartravel.backend.entity.voucher.purchaserequestvoucher;

import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.Mapper;
import com.citystartravel.backend.util.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRequestVoucherService {
    
    @Autowired
    private PurchaseRequestVoucherRepository purchaseRequestVoucherRepository;

    @Autowired
    private Mapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseRequestVoucherService.class);

    private UtilityMethods<PurchaseRequestVoucher> utilityMethods = new UtilityMethods<>();

    public PagedResponse<PurchaseRequestVoucher> getAllPurchaseRequestVouchers(UserPrincipal currentUser, int page, int size) {
        return utilityMethods.getAll(purchaseRequestVoucherRepository,currentUser,page,size);
    }

    public PurchaseRequestVoucher getPurchaseRequestVoucherById(Long purchaseRequestVoucherId, UserPrincipal currentUser) {
        return utilityMethods.getById(purchaseRequestVoucherRepository, currentUser, purchaseRequestVoucherId,"PurchaseRequestVoucher");
    }

    public PurchaseRequestVoucher createPurchaseRequestVoucher(PurchaseRequestVoucherRequest purchaseRequestVoucherRequest, @CurrentUser UserPrincipal currentUser) {
        PurchaseRequestVoucher purchaseRequestVoucher = new PurchaseRequestVoucher();
        String eventLog = utilityMethods.generateEntityCreationMessage("PurchaseRequestVoucher",String.valueOf(purchaseRequestVoucher.getSerialNo()),currentUser);
        logger.info(eventLog);
        return purchaseRequestVoucherRepository.save(purchaseRequestVoucher);
    }

    public PurchaseRequestVoucher updatePurchaseRequestVoucher(PurchaseRequestVoucher purchaseRequestVoucher) {
        return utilityMethods.update(purchaseRequestVoucherRepository,purchaseRequestVoucher);
    }

    public void deletePurchaseRequestVoucher(PurchaseRequestVoucher purchaseRequestVoucher) {
        utilityMethods.delete(purchaseRequestVoucherRepository,purchaseRequestVoucher);
    }



}
