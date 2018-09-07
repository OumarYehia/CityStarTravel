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
    public SpareType createRecords(SpareType spareType) throws SQLException {
        String dataIntoUsers = "INSERT INTO SPARESTYPES"
                + "(spareType) VALUES"
                + "(?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoUsers);
        preparedStatement.setString(1, spareType.getSpareType());

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                spareType.setSpareTypeID(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
        return spareType;
    }

    @Override
    public List<SpareType> readRecords(String spareTypeID) throws SQLException {
        // TODO: to be implemented
        return new ArrayList<>();
    }

    @Override
    public int updateRecords(SpareType spareType) throws SQLException{
        // TODO: to be implemented
        String updateSpareType ="update SPARETYPES set spareType=? where spareTypeID=?";

        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(updateSpareType);
        preparedStatement.setString(1, spareType.getSpareType());

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Updating user failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                spareType.setSpareTypeID(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Updating user failed, no ID obtained.");
            }
        }
        return affectedRows;
    }

    @Override
    public int deleteRecords(String spareType)throws SQLException {
        // TODO: to be implemented
        String deleteSpareType ="delete from SPARETYPES where spareTypeID=?";

        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(deleteSpareType);
        preparedStatement.setString(1, spareType);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Deleting user failed, no rows affected.");
        }



        return affectedRows;
    }
}
