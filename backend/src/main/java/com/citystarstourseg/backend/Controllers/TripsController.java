package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Trip;
import com.citystarstourseg.backend.Services.BusService;
import com.citystarstourseg.backend.Services.TripService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class TripsController {

    private TripService tripService;

    @RequestMapping(value="/createTrip", method = RequestMethod.POST)
    public Trip createTrip(@RequestBody Trip trip)  throws SQLException, NoSuchAlgorithmException {
        tripService = new TripService();
        return tripService.createTrip(trip.getDestination(), trip.getSerialNumber(), trip.getkmStart(), trip.getKmEnd(),trip.getBasePrice(),trip.getTaxes(),trip.getTips(),trip.getTolls(),trip.getRepairs(),trip.getDriverID(),trip.getBusID(),trip.getCapacity());
    }

    @RequestMapping("/getTrip")
    public List<Trip> getTrip(@RequestParam(value="tripID", defaultValue="-1") String tripID)  {
        tripService = new TripService();
        return tripService.getTrips(tripID);
    }

    @RequestMapping(value="/updateTrip", method = RequestMethod.POST)
    public int updateTrip(@RequestBody String tripID) throws SQLException {
        tripService = new TripService();
        return 1;
    }

    @RequestMapping(value="/deleteTrip",method = RequestMethod.DELETE)
    public int deleteTrip(@RequestParam(value="tripID") String tripID) throws SQLException {
        tripService = new TripService();
        return tripService.deleteTrips(tripID);
    }
}
