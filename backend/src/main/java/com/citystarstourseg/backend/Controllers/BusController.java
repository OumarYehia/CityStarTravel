package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.Services.BusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusController {

    private BusService busService;

    @RequestMapping("/createBus")
    public int createBus(@RequestParam(value="busPlates", defaultValue="") String busPlates,
                            @RequestParam(value="busMake", defaultValue="") String busMake)  {
        busService = new BusService();
        return busService.createBus(busPlates, busMake);
    }

    @RequestMapping("/getBus")
    public List<Bus> getBus(@RequestParam(value="busID", defaultValue="-1") String busID)  {
        busService = new BusService();
        return busService.getBuses(busID);
    }
}
