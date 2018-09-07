package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.SimplePostRequestBody;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.Services.BusService;
import com.citystarstourseg.backend.Services.SpareService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SpareController {
    private SpareService spareService;

    @RequestMapping(value="/createSparePart",method = RequestMethod.POST)
    public Spare createSparePart(@RequestParam(value="spareName", defaultValue="") String spareName,
                               @RequestParam(value="spareTypeID", defaultValue ="") String spareTypeID,
                               @RequestParam(value="busID", defaultValue ="") String busID,
                                 @RequestParam(value="spareID", defaultValue ="") String spareID)  throws SQLException {
        spareService = new SpareService();
        return spareService.createSparePart(spareName, spareTypeID, busID);        }

//    @RequestMapping(value = "/getSpare", method = RequestMethod.POST)
//    public List<Spare> getSpare(@RequestBody SimplePostRequestBody simplePostRequestBody)  {
    @RequestMapping(value = "/getSpare")
    public List<Spare> getSpare(@RequestParam(value="spareID", defaultValue="") String spareID)  {
        spareService = new SpareService();
        return spareService.getSpare(spareID);
    }

//    @RequestMapping(value = "/getSparesForBus", method = RequestMethod.POST)
//    public List<Spare> getSparesForBus(@RequestBody SimplePostRequestBody simplePostRequestBody) throws SQLException {
    @RequestMapping(value = "/getSparesForBus")
    public List<Spare> getSparesForBus(@RequestParam(value="busID", defaultValue="") String busID) throws SQLException {
        System.out.println("Inside getSparesForBus. ID: "+busID);
        spareService = new SpareService();
        return spareService.getSparesForBus(busID);
    }


    @RequestMapping(value="/updateSpare", method = RequestMethod.POST)
    public int updateSpare(@RequestBody String spareID) throws SQLException {
      spareService = new SpareService();
        return 1;
    }
    @RequestMapping(value = "/deleteSparesForBus",method = RequestMethod.DELETE)

    public int deleteSpareForBus(@RequestParam(value="busID", defaultValue = "")String busID) throws SQLException {
        spareService = new SpareService();
        return spareService.deleteSparesForBus(busID);
    }


}