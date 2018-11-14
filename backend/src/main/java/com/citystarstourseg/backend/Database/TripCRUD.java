package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Trip;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripCRUD extends EntityCRUD<Trip> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public Trip createRecords(Trip trip) throws SQLException {

        String dataIntoTrips = "INSERT INTO TRIPS"
                + "(destination,serialNumber,  kmStart, kmEnd,  price_basePrice, price_taxes, price_tips,  price_tolls,price_repairs,driverID,busID,capacity,tripDate,client) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoTrips);
        preparedStatement.setString(1, trip.getDestination());
        preparedStatement.setString(2, trip.getSerialNumber());
        preparedStatement.setDouble(3, trip.getKmStart());
        preparedStatement.setDouble(4, trip.getKmEnd());
        preparedStatement.setDouble(5, trip.getPrice_basePrice());
        preparedStatement.setDouble(6, trip.getPrice_taxes());
        preparedStatement.setDouble(7, trip.getPrice_tips());
        preparedStatement.setDouble(8, trip.getPrice_tolls());
        preparedStatement.setDouble(9, trip.getPrice_repairs());
        preparedStatement.setInt(10, trip.getDriverID());
        preparedStatement.setInt(11, trip.getBusID());
        preparedStatement.setInt(12, trip.getCapacity());
        preparedStatement.setDate(13, Date.valueOf(trip.getTripDate()));
        preparedStatement.setString(14, trip.getClient());

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
                    resultSet.getString("client"),
                    resultSet.getString("serialNumber"),
                    resultSet.getDouble("kmStart"),
                    resultSet.getDouble("kmEnd"),
                    resultSet.getDouble("price_basePrice"),
                    resultSet.getDouble("price_taxes"),
                    resultSet.getDouble("price_tips"),
                    resultSet.getDouble("price_tolls"),
                    resultSet.getDouble("price_repairs"),
                    resultSet.getInt("driverID"),
                    resultSet.getInt("busID"),
                    resultSet.getInt("capacity"),
                    resultSet.getDate("tripDate").toLocalDate()));

        }
        return trips;
    }

    @Override
    public int updateRecords(Trip trip) throws SQLException {

        String updateTrips ="update TRIPS set " +
                "destination=?,client=?,kmStart=?,kmEnd=?," +
                "driverID=?,busID=?,serialNumber=?,capacity=?," +
                "price_basePrice=?,price_taxes=?,price_tips=?,price_tolls=?," +
                "price_repairs=?,tripDate=? where tripID=?";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(updateTrips);
        preparedStatement.setString(1, trip.getDestination());
        preparedStatement.setString(2, trip.getClient());
        preparedStatement.setDouble(3, trip.getKmStart());
        preparedStatement.setDouble(4, trip.getKmEnd());

        preparedStatement.setInt(5, trip.getDriverID());
        preparedStatement.setInt(6, trip.getBusID());
        preparedStatement.setString(7, trip.getSerialNumber());
        preparedStatement.setInt(8, trip.getCapacity());

        preparedStatement.setDouble(9, trip.getPrice_basePrice());
        preparedStatement.setDouble(10, trip.getPrice_taxes());
        preparedStatement.setDouble(11, trip.getPrice_tips());
        preparedStatement.setDouble(12, trip.getPrice_tolls());

        preparedStatement.setDouble(13, trip.getPrice_repairs());
        preparedStatement.setDate(14, Date.valueOf(trip.getTripDate()));
        preparedStatement.setInt(15,Integer.parseInt(trip.getId()));

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Updating trip failed, no rows affected.");
        }

        return affectedRows;
    }

    @Override
    public int deleteRecords(String tripID) throws SQLException {

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
