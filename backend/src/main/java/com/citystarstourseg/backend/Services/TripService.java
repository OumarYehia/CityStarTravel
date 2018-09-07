package com.citystarstourseg.backend.Services;

import com.citystarstourseg.backend.DAOs.Trip;
import com.citystarstourseg.backend.Database.TripsCRUD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripService {

    private TripsCRUD tripCRUD;

    // constructor for trip retrieval
    public TripService() {
        tripCRUD = new TripsCRUD();
    }

    public Trip createTrip(String destination, String serialNumber, double kmStart, double kmEnd, double basePrice, double taxes, double tips, double tolls, double repairs, int driverID, int busID, int capacity) throws SQLException {
        return tripCRUD.createRecords(new Trip(destination,serialNumber,  kmStart, kmEnd,  basePrice, taxes, tips,  tolls,repairs,driverID,busID,capacity));
    }

    /**
     * Returns a list of trips in the database, or details of a specific trip if tripID is provided
     * @param tripID if tripID == -1, method will return all trips in the database
     * @return
     */
    public List<Trip> getTrips(String tripID) {
        try {
            if(tripID.equals("-1"))
                return tripCRUD.readRecords("");
            return tripCRUD.readRecords(tripID);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(null);
        }
    }
    public int deleteTrips(String tripID) {

        try {
            return  tripCRUD.deleteRecords(tripID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
