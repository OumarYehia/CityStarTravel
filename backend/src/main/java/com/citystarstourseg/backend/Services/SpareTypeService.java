package com.citystarstourseg.backend.Services;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.DAOs.SpareType;
import com.citystarstourseg.backend.Database.BusCRUD;
import com.citystarstourseg.backend.Database.SpareCRUD;
import com.citystarstourseg.backend.Database.SpareTypeCRUD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SpareTypeService {
    private SpareTypeCRUD spareTypeCRUD;

    // constructor for spareType retrieval
    public SpareTypeService() {
        spareTypeCRUD = new SpareTypeCRUD();
    }

    public SpareType createSpareType(String spareType) throws SQLException {

        return spareTypeCRUD.createRecords(new SpareType(spareType));
    }

    /**
     * Returns a list of SpareTypes in the database, or details of a specific bus if spareTypeID is provided
     *
     * @param spareTypeID if SpareTypeID == -1, method will return all buses in the database
     * @return
     */
    public List<SpareType> getSpareType(String spareTypeID) throws SQLException {

        if (spareTypeID.equals("-1"))
            return spareTypeCRUD.readRecords("");
        return spareTypeCRUD.readRecords(spareTypeID);

    }

    public int updateSpareType(SpareType spareType) {
        try {
            return  spareTypeCRUD.updateRecords(spareType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteSpareType(String spareTypeID) {
        try {
            return  spareTypeCRUD.deleteRecords(spareTypeID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}