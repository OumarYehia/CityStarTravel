package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.Services.BusService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class BusController {

    private BusService busService;

    @RequestMapping(value="/createBus",method = RequestMethod.POST)
    public Bus createBus(@RequestBody Bus bus)  throws SQLException, NoSuchAlgorithmException {
        busService = new BusService();
        return busService.createBus(bus.getName(), bus.getPlatesAlpha(), bus.getPlatesNum(), bus.getMake());
    }

    @RequestMapping("/getBus")
    public List<Bus> getBus(@RequestParam(value="busID", defaultValue="-1") String busID)  {
        busService = new BusService();
        return busService.getBuses(busID);
    }
    @RequestMapping(value="/updateBus", method = RequestMethod.POST)
    public int updateBus(@RequestBody Bus bus) throws SQLException {
        busService = new BusService();
        return busService.updateBuses(bus);
    }

    @RequestMapping(value = "/deleteBus",method = RequestMethod.DELETE)
    public int deleteBus(@RequestParam(value="busID") String busID) throws SQLException {
        busService = new BusService();
        return busService.deleteBuses(busID);
    }
}