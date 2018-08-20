package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserCRUD extends EntityCRUD<User> {

    @Autowired
    private DatabaseConnection databaseConnection;
    private Statement statement;
    @Override
    public int createRecords(User user) throws SQLException {

        //statement = databaseConnection.connectToDatabase();
        String dataIntoUsers = "INSERT INTO USERS"
                + "(userName, fullName, emailAddress, passwordSalt, passwordHash, mobileNumber, roleID) VALUES"
                + "(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoUsers);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getFullName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setBytes(4, user.getPasswordSalt());
        preparedStatement.setString(5, user.getPasswordHash());
        preparedStatement.setString(6, user.getMobileNumber());
        preparedStatement.setInt(7, user.getRoleID());
        // execute insert SQL statement
        return preparedStatement .executeUpdate();
    }

    public List<byte[]> getUserPasswordSaltAndHash(String username) throws SQLException {

        List<byte[]> saltAndHash = new ArrayList<>();
        String query = "select passwordSalt, passwordHash from users where userName = ?";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(query);
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.beforeFirst();
        if(resultSet.next()){
            saltAndHash.add(resultSet.getBytes("passwordSalt"));
            saltAndHash.add(resultSet.getBytes("passwordHash"));
            //return new String[] {resultSet.getString("passwordSalt"), resultSet.getString("passwordHash")};
        }
        return saltAndHash;

    }

    @Override
    public List<User> readRecords(String userID) {
        // TODO: to be implemented
        return new ArrayList<>();
    }

    @Override
    public int updateRecords(User o) {
        // TODO: to be implemented
        return -1000;
    }

    @Override
    public int deleteRecords(User o) {
        // TODO: to be implemented
        return -1000;
    }
}
