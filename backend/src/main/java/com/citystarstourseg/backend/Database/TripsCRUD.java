package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Trip;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripsCRUD extends EntityCRUD<Trip> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public Trip createRecords(Trip trip) throws SQLException {

        String dataIntoTrips = "INSERT INTO TRIPS"
                + "(destination,serialNumber,  kmStart, kmEnd,  basePrice, taxes, tips,  tolls,repairs,driverID,busID,capacity,date) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoTrips);
        preparedStatement.setString(1, trip.getDestination());
        preparedStatement.setString(2, trip.getSerialNumber());
        preparedStatement.setDouble(3, trip.getkmStart());
        preparedStatement.setDouble(4, trip.getKmEnd());
        preparedStatement.setDouble(5, trip.getBasePrice());
        preparedStatement.setDouble(6, trip.getTaxes());
        preparedStatement.setDouble(7, trip.getTips());
        preparedStatement.setDouble(8, trip.getTolls());
        preparedStatement.setDouble(9, trip.getRepairs());
        preparedStatement.setInt(10, trip.getDriverID());
        preparedStatement.setInt(11, trip.getBusID());
        preparedStatement.setInt(12, trip.getCapacity());
       // preparedStatement.setDate(13, trip.getDate());

        preparedStatement.setString(14, trip.getId());



        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating trip failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                trip.setId(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Creating trip failed, no ID obtained.");
            }
        }
        return trip;
    }

    @Override
    public List<Trip> readRecords(String tripID) throws SQLException {
        CRUDServices crudServices = new CRUDServices();
        ResultSet resultSet = crudServices.readDataFromDatabase(tripID, "trips", "tripID");
        resultSet.beforeFirst();
        List<Trip> trips = new ArrayList<>();
        while(resultSet.next()){
            trips.add(new Trip(resultSet.getString("tripID"),
                    resultSet.getString("destination"),
                    resultSet.getString("serialNumber"),
                    resultSet.getDouble("kmStart"),
                    resultSet.getDouble("kmEnd"),
                    resultSet.getDouble("basePrice"),
                    resultSet.getDouble("taxes"),
                    resultSet.getDouble("tips"),
                    resultSet.getDouble("tolls"),
                    resultSet.getDouble("repairs"),
                    resultSet.getInt("driverID"),
                    resultSet.getInt("busID"),
                    resultSet.getInt("capacity")));
                   //resultSet.getDate("date")));

        }
        return trips;
    }

    @Override
    public int updateRecords(Trip trip) throws SQLException {
        // TODO: to be implemented
        String updateTrips ="update TRIPS set destination=?,serialNumber=?,kmStart=?,kmEnd=?,basePrice=?,taxes=?,tips=?,tolls=?,repairs=?,driverID=?,busID=? where tripID=?";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(updateTrips);
        preparedStatement.setString(1, trip.getDestination());
        preparedStatement.setString(2, trip.getSerialNumber());
        preparedStatement.setDouble(3, trip.getkmStart());
        preparedStatement.setDouble(4, trip.getKmEnd());
        preparedStatement.setDouble(5, trip.getBasePrice());
        preparedStatement.setDouble(6, trip.getTaxes());
        preparedStatement.setDouble(7, trip.getTips());
        preparedStatement.setDouble(8, trip.getTolls());
        preparedStatement.setDouble(9, trip.getRepairs());
        preparedStatement.setInt(10, trip.getDriverID());
        preparedStatement.setInt(11, trip.getBusID());
        preparedStatement.setInt(12, trip.getCapacity());



        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Updating trip failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                trip.setId(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Updating trip failed, no ID obtained.");
            }
        }
        return affectedRows;

    }

    @Override
    public int deleteRecords(String tripID) throws SQLException {
        // TODO: to be implemented


        String deleteTrips ="delete from TRIPS where tripID=?";

        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(deleteTrips);
        preparedStatement.setString(1, tripID);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Deleting trip failed, no rows affected.");
        }
        return affectedRows;
    }
}
