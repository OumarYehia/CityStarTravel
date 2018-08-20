package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.Services.SpareService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class SpareController {


        private SpareService spareService;

        @RequestMapping("/createSparePart")
        public int createSparePart(@RequestParam(value="spareName", defaultValue="") String spareName,
                                   @RequestParam(value="spareTypeID", defaultValue ="") String spareTypeID,
                                   @RequestParam(value="busID", defaultValue ="") String busID)  {
            spareService = new SpareService();
            return spareService.createSparePart(spareName, spareTypeID, busID);        }

        @RequestMapping("/getSpare")
        public List<Spare> getSpare(@RequestParam(value="spareID", defaultValue="-1") String spareID)  {
            spareService = new SpareService();
            return spareService.getSpare(spareID);
        }
}