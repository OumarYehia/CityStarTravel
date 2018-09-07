package com.citystarstourseg.backend.Controllers;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.DAOs.SpareType;
import com.citystarstourseg.backend.Services.BusService;
import com.citystarstourseg.backend.Services.SpareService;
import com.citystarstourseg.backend.Services.SpareTypeService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SpareTypeController {
    private SpareTypeService spareTypeService;

    @RequestMapping(value = "/createSpareType", method = RequestMethod.POST)
    public SpareType createSpareType(@RequestParam(value="spareType", defaultValue="") String spareType,
                               @RequestParam(value="spareTypeQuantity", defaultValue ="0") String spareTypeQuantity) throws SQLException {
        spareTypeService = new SpareTypeService();
        return spareTypeService.createSpareType(spareType);        }

    @RequestMapping(value = "/getSpareType", method = RequestMethod.POST)
    public List<SpareType> getSpareType(@RequestParam(value="spareTypeID", defaultValue="-1") String spareTypeID)  {
        spareTypeService = new SpareTypeService();
        return spareTypeService.getSpareType(spareTypeID);
    }


    @RequestMapping(value="/updateSpareType", method = RequestMethod.POST)
    public int updateSpareType(@RequestBody String spareTypeID) throws SQLException {
        spareTypeService = new SpareTypeService();
        return 1;
    }

    @RequestMapping(value="/deleteSpareType",method = RequestMethod.DELETE)
    public int deleteSpareType(@RequestParam(value="spareTypeID") String spareTypeID)  throws SQLException {
        spareTypeService = new SpareTypeService();
        return spareTypeService.deleteSpareType(spareTypeID);
    }


}
