package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Order;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.DAOs.SparePartsLegendItem;
import com.citystarstourseg.backend.DAOs.SpareType;
import com.citystarstourseg.backend.Services.BusService;
import com.citystarstourseg.backend.Services.SpareService;
import com.citystarstourseg.backend.Services.SpareTypeService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SpareController {
    private SpareService spareService;

    @RequestMapping(value="/createSpare",method = RequestMethod.POST)
    public Spare createSpare(@RequestBody Spare spare)  throws SQLException {
        if(spare.getSpareTypeID().equals("-1")) { // new spare part to be inserted
            SpareTypeService spareTypeService = new SpareTypeService();
            SpareType newSpareType = spareTypeService.createSpareType(spare.getSpareName());
            spare.setSpareTypeID(newSpareType.getId());
        }

        spareService = new SpareService();
        if(spare.getBusID() == null)
            spare.setBusID("-1");
        return spareService.createSparePart(spare.getSpareName(), spare.getSpareTypeID() ,spare.getBusID(), spare.getOrderID());
    }
//
//    @RequestMapping(value = "/getOrders")
//    public List<Order> getOrders() throws SQLException {
//        spareService = new SpareService();
//        return spareService.getOrders();
//    }
    @RequestMapping(value = "/getSpare")
    public List<Spare> getSpare(@RequestParam(value="spareID", defaultValue="") String spareID)  {
        spareService = new SpareService();
        return spareService.getSpare(spareID);
    }

    @RequestMapping(value = "/getSparesForBus")
    public List<Spare> getSparesForBus(@RequestParam(value="busID", defaultValue="") String busID) throws SQLException {
        spareService = new SpareService();
        return spareService.getSparesForBus(busID);
    }

    @RequestMapping(value = "/getSparesLegend")
    public List<SparePartsLegendItem> getSparesLegend() throws SQLException {
        spareService = new SpareService();
        return spareService.getSparePartsLegend();
    }


    @RequestMapping(value="/updateSpare", method = RequestMethod.POST)
    public int updateSpare(@RequestBody Spare spare) throws SQLException {
      spareService = new SpareService();
      return spareService.updateSparePart(spare);
    }

    @RequestMapping(value = "/deleteSparesForBus",method = RequestMethod.DELETE)
    public int deleteSpareForBus(@RequestParam(value="busID", defaultValue = "")String busID) throws SQLException {
        spareService = new SpareService();
        return spareService.deleteSparesForBus(busID);
    }


}