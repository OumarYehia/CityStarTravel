package com.citystartravel.backend.entity.bus.event;

import com.citystartravel.backend.entity.bus.event.BusEvent;
import com.citystartravel.backend.entity.bus.event.BusEventService;
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
@RequestMapping("/api/buses/events")
class BusEventController {

    @Autowired
    private BusEventService busEventService;

    private static final Logger logger = LoggerFactory.getLogger(BusEventController.class);

    @GetMapping("/getAll")
    public PagedResponse<BusEvent> getBusEvents(@CurrentUser UserPrincipal currentUser,
                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return busEventService.getAllBusEvents(currentUser, page, size);
    }

    @GetMapping("/get")
    public BusEvent getBusEvent(@CurrentUser UserPrincipal currentUser,
                                @RequestParam(value = "id") Long id) {
        return busEventService.getBusEventById(id, currentUser);
    }

    @GetMapping("/getByBus")
    public BusEvent getBusEventByBus(@CurrentUser UserPrincipal currentUser,
                                @RequestParam(value = "id") Long id) {
        return busEventService.getBusEventById(id, currentUser);
    }

/*    @PostMapping("/create")
    public ResponseEntity<?> createBusEvent(@CurrentUser UserPrincipal currentUser,
                                       @RequestBody BusEventRequest busEventRequest) {
        try{
            BusEvent busEvent = busEventService.createBusEvent(busEventRequest, currentUser);
            return ResponseEntity.ok(busEvent);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(
                    new ApiResponse(false,"Unable to create busEvent."),HttpStatus.BAD_REQUEST);
        }

    }*/

}
