package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.DAOs.Drivers;
import com.citystarstourseg.backend.DAOs.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DriversCRUD extends EntityCRUD<Drivers> {

    @Autowired
    private DatabaseConnection databaseConnection;
    private Statement statement;
   @Override
    public Drivers createRecords(Drivers drivers) throws SQLException {

        //statement = databaseConnection.connectToDatabase();
        String dataIntoDrivers = "INSERT INTO DRIVERS"
                + "(driverName) VALUES"
                + "(?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoDrivers);
        preparedStatement.setString(1, drivers.getName());

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating driver failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                drivers.setId(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Creating driver failed, no ID obtained.");
            }
        }
        return drivers;
    }





    @Override
    public List<Drivers> readRecords(String driverID) throws SQLException {
        CRUDServices crudServices = new CRUDServices();
        ResultSet resultSet = crudServices.readDataFromDatabase(driverID, "driver", "driverID");
        resultSet.beforeFirst();
        List<Drivers> driver = new ArrayList<>();
        while (resultSet.next()) {
            driver.add(new Drivers(resultSet.getString("driverID"),
                    resultSet.getString("driverName")));
        }
        return driver;
    }

        @Override
        public int updateRecords(Drivers driver) throws SQLException {
            // TODO: to be implemented
            String updateDrivers ="update Drivers set driverName=? where driverID=?";
            PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(updateDrivers);
            preparedStatement.setString(1, driver.getName());



            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating driver failed, no rows affected.");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    driver.setId(generatedKeys.getString(1));
                }
                else {
                    throw new SQLException("Updating driver failed, no ID obtained.");
                }
            }
            return affectedRows;

        }

    @Override
    public int deleteRecords(String driverID) throws SQLException {
        // TODO: to be implemented


        String deleteDrivers ="delete from DRIVERS where driverID=?";

        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(deleteDrivers);
        preparedStatement.setString(1, driverID);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Deleting driver failed, no rows affected.");
        }
        return affectedRows;
    }
}
