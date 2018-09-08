package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Trip;
import com.citystarstourseg.backend.Services.TripService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class TripController {

    private TripService tripService;

    @RequestMapping(value="/createTrip", method = RequestMethod.POST)
    public Trip createTrip(@RequestBody Trip trip)  throws SQLException, NoSuchAlgorithmException {
        tripService = new TripService();
        return tripService.createTrip(trip.getDestination(), trip.getClient(), trip.getSerialNumber(), trip.getKmStart(), trip.getKmEnd(),trip.getPrice_basePrice(),trip.getPrice_taxes(),trip.getPrice_tips(),trip.getPrice_tolls(),trip.getPrice_repairs(),trip.getDriverID(),trip.getBusID(),trip.getCapacity(), trip.getTripDate());
    }

    @RequestMapping(value = "/getTrips", method = RequestMethod.GET)
    public List<Trip> getTrips(@RequestParam(value="tripID", defaultValue="-1") String tripID)  {
        tripService = new TripService();
        return tripService.getTrips(tripID);
    }

    @RequestMapping(value="/updateTrip", method = RequestMethod.POST)
    public int updateTrip(@RequestBody Trip trip) throws SQLException {
        tripService = new TripService();
        return tripService.updateTrip(trip);
    }

    @RequestMapping(value="/deleteTrip",method = RequestMethod.DELETE)
    public int deleteTrip(@RequestParam(value="tripID") String tripID) throws SQLException {
        tripService = new TripService();
        return tripService.deleteTrips(tripID);
    }
}
