package com.citystartravel.backend.entity.voucher.stockissue;

import com.citystartravel.backend.entity.voucher.item.VoucherUtility;
import com.citystartravel.backend.exception.AppException;
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
@RequestMapping("/api/vouchers/stockissue")
public class StockIssueController {
    
    @Autowired
    private StockIssueService stockIssueService;

    @Autowired
    private VoucherUtility voucherUtility;

    private static final Logger logger = LoggerFactory.getLogger(StockIssueController.class);

    @GetMapping("/getAll")
    public ResponseEntity<?> getStockIssueVouchers(@CurrentUser UserPrincipal currentUser,
                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        try{
            PagedResponse<StockIssue> stockIssuePagedResponse = stockIssueService.getAllStockIssueVouchers(currentUser, page, size);
            return ResponseEntity.ok(stockIssuePagedResponse);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ApiResponse(false,"Unable to fetch Stock Issue Vouchers."),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStockIssueVoucher(@CurrentUser UserPrincipal currentUser,
                      @RequestParam(value = "id") Long id) {
        try{
            StockIssue stockIssue = stockIssueService.getStockIssueVoucherById(id, currentUser);
            return ResponseEntity.ok(stockIssue);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ApiResponse(false,"Stock Issue Voucher with id: "+id+" not found."),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStockIssueVoucher(@CurrentUser UserPrincipal currentUser,
                                       @RequestBody StockIssueDtoRequest stockIssueDtoRequest) {
        try{
            StockIssue stockIssue = stockIssueService.createStockIssueVoucher(stockIssueDtoRequest, currentUser);
            return ResponseEntity.ok(stockIssue);
        }
        catch (AppException appEx) {
            logger.error(appEx.getMessage(), appEx);
            return new ResponseEntity<>(
                    new ApiResponse(false,appEx.getMessage()),HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ApiResponse(false,"Unable to create stockIssueVoucher."),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStockIssueVoucher(@CurrentUser UserPrincipal currentUser,
                                                            @RequestParam(value = "id") Long id) {
        try {
            stockIssueService.deleteStockIssueVoucher(
                    stockIssueService.getStockIssueVoucherById(id, currentUser));
            logger.info("[DELETED] StockIssue with id: "+id+" deleted.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(
                    new ApiResponse(false,"Unable to delete stockIssueVoucher."),HttpStatus.BAD_REQUEST);
        }

    }
}
