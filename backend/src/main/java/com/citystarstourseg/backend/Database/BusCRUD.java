package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Bus;
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
    public int createRecords(Bus bus) throws SQLException {

        String dataIntoUsers = "INSERT INTO BUSES"
                + "(busPlates, busMake) VALUES"
                + "(?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoUsers);
        preparedStatement.setString(1, bus.getPlates());
        preparedStatement.setString(2, bus.getMake());
        // execute insert SQL statement
        return preparedStatement .executeUpdate();
    }

    @Override
    public List<Bus> readRecords(String busID) throws SQLException {
        String query;
        PreparedStatement preparedStatement;
        if(busID.isEmpty()) {
            query = "select * from buses";
            preparedStatement = DatabaseConnection.connectToDatabase(query);
        }
        else {
            query = "select * from buses where busID = ?";
            preparedStatement = DatabaseConnection.connectToDatabase(query);
            preparedStatement.setInt(1, Integer.parseInt(busID));
        }

        List<Bus> buses = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.beforeFirst();
        while(resultSet.next()){
            buses.add(new Bus(resultSet.getString("busID"),
                              resultSet.getString("busPlates"),
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
