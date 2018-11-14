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
    public SpareType createSpareType(@RequestBody SpareType spareType) throws SQLException {
        spareTypeService = new SpareTypeService();
        return spareTypeService.createSpareType(spareType.getName());        }

    @RequestMapping(value = "/getSpareTypes", method = RequestMethod.GET)
    public List<SpareType> getSpareTypes(@RequestParam(value="spareTypeID", defaultValue="-1") String spareTypeID) throws SQLException {
        spareTypeService = new SpareTypeService();
        return spareTypeService.getSpareType(spareTypeID);
    }


    @RequestMapping(value="/updateSpareType", method = RequestMethod.POST)
    public int updateSpareType(@RequestBody SpareType spareType) throws SQLException {
        spareTypeService = new SpareTypeService();
        return spareTypeService.updateSpareType(spareType);
    }

    @RequestMapping(value="/deleteSpareType",method = RequestMethod.DELETE)
    public int deleteSpareType(@RequestParam(value="spareTypeID") String spareTypeID)  throws SQLException {
        spareTypeService = new SpareTypeService();
        return spareTypeService.deleteSpareType(spareTypeID);
    }


}
