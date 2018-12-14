package com.citystartravel.backend.entity.voucher.purchaserequestvoucher;

import com.citystartravel.backend.entity.voucher.purchaserequestvoucher.PurchaseRequestVoucher;
import com.citystartravel.backend.entity.voucher.purchaserequestvoucher.PurchaseRequestVoucherService;
import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRequestVoucherService {
    
    @Autowired
    private PurchaseRequestVoucherRepository purchaseRequestVoucherRepository;


    private static final Logger logger = LoggerFactory.getLogger(PurchaseRequestVoucherService.class);

    private UtilityMethods<PurchaseRequestVoucher> utilityMethods = new UtilityMethods<>();

    public PagedResponse<PurchaseRequestVoucher> getAllPurchaseRequestVouchers(UserPrincipal currentUser, int page, int size) {
        return utilityMethods.getAll(purchaseRequestVoucherRepository,currentUser,page,size);
    }

    public PurchaseRequestVoucher getPurchaseRequestVoucherById(Long purchaseRequestVoucherId, UserPrincipal currentUser) {
        return utilityMethods.getById(purchaseRequestVoucherRepository, currentUser, purchaseRequestVoucherId,"PurchaseRequestVoucher");
    }

//    public PurchaseRequestVoucher createPurchaseRequestVoucher(PurchaseRequestVoucherRequest purchaseRequestVoucherRequest) {
//        PurchaseRequestVoucher purchaseRequestVoucher = new PurchaseRequestVoucher();
//        purchaseRequestVoucher.setName(purchaseRequestVoucherRequest.getName());
//        logger.info("[CREATED] PurchaseRequestVoucher "+purchaseRequestVoucher.getName()+" Created.");
//        return purchaseRequestVoucherRepository.save(purchaseRequestVoucher);
//    }
}
