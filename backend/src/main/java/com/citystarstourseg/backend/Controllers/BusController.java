package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.Services.BusService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class BusController {

    private BusService busService;

    @RequestMapping("/createBus")
    /*public int createBus(@RequestParam(value="busName", defaultValue="") String busName,
                         @RequestParam(value="busPlatesAlpha", defaultValue="") String busPlatesAlpha,
                         @RequestParam(value="busPlatesNum", defaultValue="") String busPlatesNum,
                         @RequestParam(value="busMake", defaultValue="") String busMake)  {*/
    public Bus createBus(@RequestBody Bus bus)  throws SQLException, NoSuchAlgorithmException {
        busService = new BusService();
        return busService.createBus(bus.getName(), bus.getPlatesAlpha(), bus.getPlatesNum(), bus.getMake());
    }

    @RequestMapping("/getBus")
    public List<Bus> getBus(@RequestParam(value="busID", defaultValue="-1") String busID)  {
        busService = new BusService();
        return busService.getBuses(busID);
    }
}
