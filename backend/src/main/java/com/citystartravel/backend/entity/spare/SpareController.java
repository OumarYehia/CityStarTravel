package com.citystartravel.backend.entity.spare;

import com.citystartravel.backend.entity.spare.Spare;
import com.citystartravel.backend.entity.spare.SpareRequest;
import com.citystartravel.backend.entity.spare.SpareService;
import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spare")
public class SpareController {

    @Autowired
    private SpareService spareService;

    private static final Logger logger = LoggerFactory.getLogger(com.citystartravel.backend.entity.spare.SpareController.class);

    @GetMapping("/getAll")
    public PagedResponse<Spare> getSparees(@CurrentUser UserPrincipal currentUser,
                                                   @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                   @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return spareService.getAllSpares(currentUser, page, size);
    }

    @GetMapping("/get")
    public Spare getSpare(@CurrentUser UserPrincipal currentUser,
                                  @RequestParam(value = "spareID") Long id) {
        return spareService.getSpareById(id, currentUser);
    }

    @GetMapping("/bus/getAll")
    public Spare getAllSparesForBus(@CurrentUser UserPrincipal currentUser,
                          @RequestParam(value = "spareID") Long id) {
        return spareService.getSpareById(id, currentUser);
    }

}