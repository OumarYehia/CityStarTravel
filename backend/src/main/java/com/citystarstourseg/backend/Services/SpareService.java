package com.citystarstourseg.backend.Services;
import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.DAOs.Order;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.DAOs.SparePartsLegendItem;
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

    public Spare createSparePart(String spareName, String spareTypeID,String busID, String orderID) throws SQLException{
        return spareCRUD.createRecords(new Spare(spareName,spareTypeID,busID, orderID));
    }

    public int updateSparePart(Spare spare) throws  SQLException{
        return spareCRUD.updateRecords(spare);
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
            return new ArrayList<>();
        }
    }

    public List<Order> getOrder() throws SQLException {
        return spareCRUD.getOrders();
    }

    public List<Spare> getSparesForBus(String bus_id) throws SQLException {
        return spareCRUD.readSparesForBus(bus_id);
    }

    public int deleteSparesForBus(String busID) throws SQLException {
       // int SPAREID=Integer.parseInt(spareID);
        return spareCRUD.deleteRecords(busID);
    }

    public List<SparePartsLegendItem> getSparePartsLegend() throws SQLException {
        return spareCRUD.getSparePartsLegend();
    }

    public int updateSpare(Spare spare) throws SQLException {
        return spareCRUD.updateRecords(spare);
    }
}
