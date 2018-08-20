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
public class SpareCRUD extends EntityCRUD<Spare> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public int createRecords(Spare spare) throws SQLException {
        String dataIntoUsers = "INSERT INTO SPARES"
                + "(spareName, spareTypeID, busID) VALUES"
                + "(?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoUsers);
        preparedStatement.setString(1, spare.getSpareName());
        preparedStatement.setInt(2, Integer.parseInt(spare.getSpareTypeID()));
        preparedStatement.setInt(3, Integer.parseInt(spare.getBusID()));
        // execute insert SQL statement
        return preparedStatement .executeUpdate();
    }

    @Override
    public List<Spare> readRecords(String spareID) throws SQLException {
        // TODO: to be implemented
        return new ArrayList<>();
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
