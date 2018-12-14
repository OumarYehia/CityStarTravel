package com.citystartravel.backend.entity.bus;


import com.citystartravel.backend.entity.bus.event.BusEvent;
import com.citystartravel.backend.entity.bus.event.BusEventRequest;
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

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    private BusService busService;

    private static final Logger logger = LoggerFactory.getLogger(BusController.class);

    @GetMapping("/getAll")
    public ResponseEntity<BusResponse> getBuses(@CurrentUser UserPrincipal currentUser,
                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        try{
            PagedResponse<BusResponse> pagedResponse = busService.getAllBuses(currentUser, page, size);
            logger.debug(pagedResponse.toString());
            return new ResponseEntity(pagedResponse,HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity(
                    new ApiResponse(false,"Unable to getAll buses."),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public BusResponse getBus(@CurrentUser UserPrincipal currentUser,
                      @RequestParam(value = "id") Long id) {
        return busService.getBusById(id, currentUser);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createBus(@CurrentUser UserPrincipal currentUser,
                                      @RequestBody BusRequest busRequest) {
        try{
            BusResponse busResponse = busService.createBus(busRequest, currentUser);
            return ResponseEntity.ok(busResponse);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity(
                    new ApiResponse(false,"Unable to create bus."),HttpStatus.BAD_REQUEST);
        }

    }

    // ------------------------ EVENTS ------------------------
    @GetMapping("/events")
    public List<BusEvent> getEvents(@CurrentUser UserPrincipal currentUser,
                                   @RequestParam(value = "id") Long id) {
        return busService.getBusEvents(id);
    }

    /*@PostMapping("/addEvents")
    public ResponseEntity<?> addEvents(@CurrentUser UserPrincipal currentUser,
                                   @RequestParam(value = "id") Long id,
                                   @RequestBody List<BusEventRequest> busEvents) {

        Bus bus = busService.getBusById(id, currentUser);
        BusEvent busEvent = new BusEvent()
        try{
            for(BusEventRequest event : busEvents) {
                bus.addBusEvent(event);
            }
            return ResponseEntity.ok(bus.getEvents());
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity(
                    new ApiResponse(false,"Unable to add events to bus "+bus.getName()),HttpStatus.BAD_REQUEST);
        }
    }*/
}
