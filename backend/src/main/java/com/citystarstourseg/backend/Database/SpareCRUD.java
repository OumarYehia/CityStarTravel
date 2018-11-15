package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Order;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.DAOs.SparePartsLegendItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SpareCRUD extends EntityCRUD<Spare> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public Spare createRecords(Spare spare) throws SQLException {
        String dataIntoUsers = "INSERT INTO SPARES"
                + "(spareName, spareTypeID, busID, orderID) VALUES"
                + "(?,?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoUsers);
        preparedStatement.setString(1, spare.getSpareName());
        preparedStatement.setInt(2, Integer.parseInt(spare.getSpareTypeID()));
        preparedStatement.setInt(3, Integer.parseInt(spare.getBusID()));
        preparedStatement.setInt(4, Integer.parseInt(spare.getOrderID()));

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating spare failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                spare.setSpareID(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Creating spare failed, no ID obtained.");
            }
        }
        return spare;
    }

    @Override
    public List<Spare> readRecords(String spareID) throws SQLException {
        return readFromDatabase(spareID, "");
    }

    public List<Spare> readSparesForBus(String bus_id) throws SQLException {
        return readFromDatabase("",bus_id);
    }

    /**
     * Fetches spare parts from database based on multiple scenarios
     * 1- Get all   2- Get by ID    3- Get spare parts related to specific bus
     * @param spareID spare part ID
     * @param busID bus ID to fetch spare parts attached
     * @return List<Spare> queried spare parts
     */
    private List<Spare> readFromDatabase(String spareID, String busID) throws SQLException {
        String query;
        PreparedStatement preparedStatement;
        if(busID.isEmpty()) {
            if(spareID.isEmpty()) { // get all spare parts for all buses
                query = "SELECT s.spareID, s.spareName,s.spareTypeID, s.orderID, st.spareType, b.busID, b.busName " +
                        "FROM spares s, sparetypes st, buses b " +
                        "WHERE s.busID = b.busID and s.spareTypeID = st.spareTypeID";
                preparedStatement = DatabaseConnection.connectToDatabase(query);
            }
            else { // get a specific spare part
                // TODO: Needs to be reimplemented
                query = "SELECT s.*, st.spareType, b.busName, COUNT(s.spareID) as quantity " +
                        "FROM spares s, sparetypes st, buses b, orders o " +
                        "WHERE s.spareTypeID = st.spareTypeID AND s.spareID = ? AND s.busID = b.busID  and s.orderID = o.orderID";
                preparedStatement = DatabaseConnection.connectToDatabase(query);
                preparedStatement.setInt(1, Integer.parseInt(spareID));
            }
        }
        else { // get all spare parts for specific bus
            query = "SELECT s.spareID, s.spareName, s.spareTypeID, s.orderID, st.spareType, b.busID, b.busName " +
                    "FROM spares s, sparetypes st, buses b " +
                    "WHERE s.busID = b.busID and s.spareTypeID = st.spareTypeID and s.busID = ?";
            preparedStatement = DatabaseConnection.connectToDatabase(query);
            preparedStatement.setInt(1, Integer.parseInt(busID));
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.beforeFirst();
        List<Spare> spares = new ArrayList<>();
        while(resultSet.next()){

            spares.add(new Spare(resultSet.getString("spareID"),
                    resultSet.getString("spareName"),
                    resultSet.getString("spareTypeID"),
                    resultSet.getString("spareType"),
                    resultSet.getString("busID"),
                    resultSet.getString("busName"),
                    resultSet.getString("orderID")
            ));
        }
        return spares;
    }

    public List<Order> getOrders() throws SQLException {
        String query;
        PreparedStatement preparedStatement;

        query = "SELECT orderID, orderSerialNumber from orders ";
        preparedStatement = DatabaseConnection.connectToDatabase(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.beforeFirst();
        List<Order> orders = new ArrayList<>();
        while(resultSet.next()){

            orders.add(new Order(resultSet.getString("orderID"),
                    resultSet.getString("orderSerialNumber")));
        }
        return orders;
    }

    @Override
    public int updateRecords(Spare spare) throws SQLException {
        // TODO: to be implemented
        String updateSpare ="update SPARES set spareName=?,spareTypeID=?,busID=? where spareID=?";

        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(updateSpare);
        preparedStatement.setString(1, spare.getSpareName());
        preparedStatement.setInt(2, Integer.parseInt(spare.getSpareTypeID()));
        preparedStatement.setInt(3, Integer.parseInt(spare.getBusID()));
        preparedStatement.setInt(4, Integer.parseInt(spare.getSpareID()));

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Updating spare failed, no rows affected.");
        }
        return affectedRows;
    }

    @Override
    public int deleteRecords(String spareID) throws SQLException {
       String deleteSpare ="delete from SPARES where spareID=?";
       PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(deleteSpare);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Deleting spare failed, no rows affected.");
        }
        return affectedRows;
    }

    public List<SparePartsLegendItem> getSparePartsLegend() throws SQLException {
        CallableStatement callableStatement = DatabaseConnection.callStoredProcedure("sp_spareType_legend");
        ResultSet resultSet = callableStatement.executeQuery();
        resultSet.beforeFirst();
        List<SparePartsLegendItem> sparePartsLegendItems = new ArrayList<>();
        while(resultSet.next()){
            sparePartsLegendItems.add(new SparePartsLegendItem(resultSet.getString("spareTypeID"),
                    resultSet.getString("spareType"),
                    Integer.parseInt(resultSet.getString("quantityAvailable")),
                    Integer.parseInt(resultSet.getString("quantityAllocated"))));
        }
        return sparePartsLegendItems;
    }
}
