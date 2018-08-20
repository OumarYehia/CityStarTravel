package com.citystarstourseg.backend.Controllers;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.DAOs.SpareType;
import com.citystarstourseg.backend.Services.SpareService;
import com.citystarstourseg.backend.Services.SpareTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class SpareTypeController {
    private SpareTypeService spareTypeService;

    @RequestMapping(value = "/createSpareType", method = RequestMethod.POST)
    public int createSpareType(@RequestParam(value="spareType", defaultValue="") String spareType,
                               @RequestParam(value="spareTypeQuantity", defaultValue ="0") String spareTypeQuantity)  {
        spareTypeService = new SpareTypeService();
        return spareTypeService.createSpareType(spareType);        }

    @RequestMapping(value = "/getSpareType", method = RequestMethod.POST)
    public List<SpareType> getSpareType(@RequestParam(value="spareTypeID", defaultValue="-1") String spareTypeID)  {
        spareTypeService = new SpareTypeService();
        return spareTypeService.getSpareType(spareTypeID);
    }


}
