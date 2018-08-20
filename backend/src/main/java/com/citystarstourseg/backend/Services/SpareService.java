package com.citystarstourseg.backend.Services;
import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.Database.BusCRUD;
import com.citystarstourseg.backend.Database.SpareCRUD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpareService {

    private SpareCRUD spareCRUD;

    // constructor for spare retrieval
    public SpareService() {
        spareCRUD = new SpareCRUD();
    }

    public int createSparePart(String spareName, String spareTypeID,String busID) {
        try {
            return spareCRUD.createRecords(new Spare(spareName,spareTypeID,busID));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return - 1;
    }

    /**
     * Returns a list of SpareParts in the database, or details of a specific bus if spareID is provided
     * @param spareID if SpareID == -1, method will return all buses in the database
     * @return
     */
    public List<Spare> getSpare(String spareID) {
        try {
            if(spareID.equals("-1"))
                return spareCRUD.readRecords("");
            return spareCRUD.readRecords(spareID);

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(null);
        }
    }

}
