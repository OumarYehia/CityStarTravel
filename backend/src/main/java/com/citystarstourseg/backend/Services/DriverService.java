package com.citystarstourseg.backend.Services;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.DAOs.Drivers;
import com.citystarstourseg.backend.Database.BusCRUD;
import com.citystarstourseg.backend.Database.DriversCRUD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverService {

    private DriversCRUD driverCRUD;

    // constructor for bus retrieval
    public DriverService() {
        driverCRUD = new DriversCRUD();
    }

    public Drivers createDriver(String driversName) throws SQLException {
        return driverCRUD.createRecords(new Drivers(driversName));
    }

    /**
     * Returns a list of drivers in the database, or details of a specific driver if driverID is provided
     * @param driverID if driverID == -1, method will return all buses in the database
     * @return
     */
    public List<Drivers> getDrivers(String driverID) {
        try {
            if(driverID.equals("-1"))
                return driverCRUD.readRecords("");
            return driverCRUD.readRecords(driverID);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(null);
        }
    }


    public int updateDriver(Drivers driver) throws SQLException {
        return driverCRUD.updateRecords(driver);
    }
    public int deleteDrivers(String driverID) {

        try {
            return  driverCRUD.deleteRecords(driverID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
