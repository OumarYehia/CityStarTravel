package com.citystartravel.backend.entity.voucher.purchaserequestvoucher;

import com.citystartravel.backend.entity.voucher.item.VoucherUtility;
import com.citystartravel.backend.payload.response.ApiResponse;
import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/vouchers/purchaserequest")
public class PurchaseRequestVoucherController {
    
    @Autowired
    private PurchaseRequestVoucherService purchaseRequestVoucherService;

    @Autowired
    private VoucherUtility voucherUtility;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseRequestVoucherController.class);

    @GetMapping("/getAll")
    public ResponseEntity<?> getPurchaseRequestVouchers(@CurrentUser UserPrincipal currentUser,
                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        try{
            PagedResponse<PurchaseRequestVoucher> purchaseRequestVouchers = purchaseRequestVoucherService.getAllPurchaseRequestVouchers(currentUser, page, size);
            return ResponseEntity.ok(purchaseRequestVouchers);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity(
                    new ApiResponse(false,"Unable to fetch Purchase Request Vouchers."),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getPurchaseRequestVoucher(@CurrentUser UserPrincipal currentUser,
                      @RequestParam(value = "id") Long id) {
        try{
            PurchaseRequestVoucher purchaseRequestVoucher = purchaseRequestVoucherService.getPurchaseRequestVoucherById(id, currentUser);
            return ResponseEntity.ok(purchaseRequestVoucher);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity(
                    new ApiResponse(false,"Purchase Request Voucher with id: "+id+" not found."),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPurchaseRequestVoucher(@CurrentUser UserPrincipal currentUser,
                                       @RequestBody PurchaseRequestVoucherRequest purchaseRequestVoucherRequest) {
        try{
            PurchaseRequestVoucher purchaseRequestVoucher = purchaseRequestVoucherService.createPurchaseRequestVoucher(purchaseRequestVoucherRequest, currentUser);
            return ResponseEntity.ok(purchaseRequestVoucher);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity(
                    new ApiResponse(false,"Unable to create purchaseRequestVoucher."),HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePurchaseRequestVoucher(@CurrentUser UserPrincipal currentUser,
                                                            @RequestParam(value = "id") Long id) {
        try {
            purchaseRequestVoucherService.deletePurchaseRequestVoucher(
                    purchaseRequestVoucherService.getPurchaseRequestVoucherById(id, currentUser));
            logger.info("[DELETED] PurchaseRequestVoucher with id: "+id+" deleted.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
            return new ResponseEntity(
                    new ApiResponse(false,"Unable to delete purchaseRequestVoucher."),HttpStatus.BAD_REQUEST);
        }

    }
}
