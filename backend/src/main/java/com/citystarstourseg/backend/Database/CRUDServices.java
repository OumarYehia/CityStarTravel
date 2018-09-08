package com.citystarstourseg.backend.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class CRUDServices {

     ResultSet readDataFromDatabase(String id, String tableName, String tableID) throws SQLException {
        String query;
        PreparedStatement preparedStatement;
        if(id.isEmpty()) {
            query = "select * from "+tableName;
            preparedStatement = DatabaseConnection.connectToDatabase(query);
        }
        else {
            query = "select * from "+tableName+" where "+tableID+" = ?";
            preparedStatement = DatabaseConnection.connectToDatabase(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
        }
        return preparedStatement.executeQuery();
    }
}
