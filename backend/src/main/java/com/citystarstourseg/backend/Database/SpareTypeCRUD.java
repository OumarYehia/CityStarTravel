package com.citystarstourseg.backend.Database;
import com.citystarstourseg.backend.DAOs.Bus;
import com.citystarstourseg.backend.DAOs.Spare;
import com.citystarstourseg.backend.DAOs.SpareType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpareTypeCRUD extends EntityCRUD<SpareType> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public int createRecords(SpareType spareType) throws SQLException {
        String dataIntoUsers = "INSERT INTO SPARESTYPES"
                + "(spareType) VALUES"
                + "(?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoUsers);
        preparedStatement.setString(1, spareType.getSpareType());
        // execute insert SQL statement
        return preparedStatement .executeUpdate();
    }

    @Override
    public List<SpareType> readRecords(String spareTypeID) throws SQLException {
        // TODO: to be implemented
        return new ArrayList<>();
    }

    @Override
    public int updateRecords(SpareType spareType) {
        // TODO: to be implemented
        return -1000;
    }

    @Override
    public int deleteRecords(SpareType spareType) {
        // TODO: to be implemented
        return -1000;
    }
}
