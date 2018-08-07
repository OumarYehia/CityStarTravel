package com.citystarstourseg.backend.Services;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.Database.BusCRUD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusService {

    private BusCRUD busCRUD;

    // constructor for bus retrieval
    public BusService() {
        busCRUD = new BusCRUD();
    }

    public int createBus(String busPlates, String busMake) {
        try {
            return busCRUD.createRecords(new Bus(busPlates,busMake));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return - 1;
    }

    /**
     * Returns a list of buses in the database, or details of a specific bus if busID is provided
     * @param busID if busID == -1, method will return all buses in the database
     * @return
     */
    public List<Bus> getBuses(String busID) {
        try {
            if(busID.equals("-1"))
                return busCRUD.readRecords("");
            return busCRUD.readRecords(busID);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(null);
        }
    }

}
