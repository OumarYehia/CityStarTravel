package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Spare;
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
                + "(spareName, spareTypeID, busID) VALUES"
                + "(?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoUsers);
        preparedStatement.setString(1, spare.getSpareName());
        preparedStatement.setInt(2, Integer.parseInt(spare.getSpareTypeID()));
        preparedStatement.setInt(3, Integer.parseInt(spare.getBusID()));

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
                query = "SELECT s.spareID, s.spareName,s.spareTypeID, st.spareType, b.busID, b.busName " +
                        "FROM spares s, sparetypes st, buses b " +
                        "WHERE s.busID = b.busID and s.spareTypeID = st.spareTypeID";
                preparedStatement = DatabaseConnection.connectToDatabase(query);
            }
            else { // get a specific spare part
                // TODO: Needs to be reimplemented
                query = "SELECT s.*, st.spareType, b.busName, COUNT(s.spareID) as quantity " +
                        "FROM spares s, sparetypes st, buses b " +
                        "WHERE s.spareTypeID = st.spareTypeID AND s.spareID = ? AND s.busID = b.busID";
                preparedStatement = DatabaseConnection.connectToDatabase(query);
                preparedStatement.setInt(1, Integer.parseInt(spareID));
            }
        }
        else { // get all spare parts for specific bus
            query = "SELECT s.spareID, s.spareName, s.spareTypeID, st.spareType, b.busID, b.busName " +
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
                    3
                    /* TODO: fix quantity in SQL,resultSet.getInt("quantity")*/
            ));
        }
        return spares;
    }

    @Override
    public int updateRecords(Spare spare) {
        // TODO: to be implemented
        return -1000;
    }

    @Override
    public int deleteRecords(Spare spare) {
        // TODO: to be implemented
        return -1000;
    }
}
