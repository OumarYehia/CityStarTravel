package com.citystartravel.backend.entity.voucher.stockreceived;

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

@RestController
@RequestMapping("/api/vouchers/stockreceived")
public class StockReceivedController {
    
    @Autowired
    private StockReceivedService stockReceivedService;

    @Autowired
    private VoucherUtility voucherUtility;

    private static final Logger logger = LoggerFactory.getLogger(StockReceivedController.class);

    @GetMapping("/getAll")
    public ResponseEntity<?> getStockReceivedVouchers(@CurrentUser UserPrincipal currentUser,
                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        try{
            PagedResponse<StockReceived> stockReceivedPagedResponse = stockReceivedService.getAllStockReceivedVouchers(currentUser, page, size);
            return ResponseEntity.ok(stockReceivedPagedResponse);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ApiResponse(false,"Unable to fetch Stock Received Vouchers."),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStockReceivedVoucher(@CurrentUser UserPrincipal currentUser,
                      @RequestParam(value = "id") Long id) {
        try{
            StockReceived stockReceived = stockReceivedService.getStockReceivedVoucherById(id, currentUser);
            return ResponseEntity.ok(stockReceived);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ApiResponse(false,"Stock Received Voucher with id: "+id+" not found."),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStockReceivedVoucher(@CurrentUser UserPrincipal currentUser,
                                       @RequestBody StockReceivedDtoRequest stockReceivedDtoRequest) {
        try{
            StockReceived stockReceived = stockReceivedService.createStockReceivedVoucher(stockReceivedDtoRequest, currentUser);
            return ResponseEntity.ok(stockReceived);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ApiResponse(false,"Unable to create stockReceivedVoucher."),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStockReceivedVoucher(@CurrentUser UserPrincipal currentUser,
                                                            @RequestParam(value = "id") Long id) {
        try {
            stockReceivedService.deleteStockReceivedVoucher(
                    stockReceivedService.getStockReceivedVoucherById(id, currentUser));
            logger.info("[DELETED] StockReceived with id: "+id+" deleted.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(
                    new ApiResponse(false,"Unable to delete stockReceivedVoucher."),HttpStatus.BAD_REQUEST);
        }

    }
}
