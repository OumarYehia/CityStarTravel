package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.DAOs.Spare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BusCRUD extends EntityCRUD<Bus> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public Bus createRecords(Bus bus) throws SQLException {

        String dataIntoBuses = "INSERT INTO BUSES"
                + "(busName, busPlatesAlpha, busPlatesNumbers, busMake) VALUES"
                + "(?,?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoBuses);
        preparedStatement.setString(1, bus.getName());
        preparedStatement.setString(2, bus.getPlatesAlpha());
        preparedStatement.setString(3, bus.getPlatesNum());
        preparedStatement.setString(4, bus.getMake());


        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating bus failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                bus.setId(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Creating bus failed, no ID obtained.");
            }
        }
        return bus;
    }

    @Override
    public List<Bus> readRecords(String busID) throws SQLException {
        CRUDServices crudServices = new CRUDServices();
        ResultSet resultSet = crudServices.readDataFromDatabase(busID, "buses", "busID");
        resultSet.beforeFirst();
        List<Bus> buses = new ArrayList<>();
        while(resultSet.next()){
            buses.add(new Bus(resultSet.getString("busID"),
                              resultSet.getString("busName"),
                              resultSet.getString("busPlatesAlpha"),
                              resultSet.getString("busPlatesNumbers"),
                              resultSet.getString("busMake")));
        }
        return buses;
    }

    @Override
    public int updateRecords(Bus bus) {
        // TODO: to be implemented
        return -1000;
    }

    @Override
    public int deleteRecords(Bus bus) {
        // TODO: to be implemented
        return -1000;
    }
}
