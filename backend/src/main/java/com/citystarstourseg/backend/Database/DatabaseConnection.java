package com.citystarstourseg.backend.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseConnection {

    private static Statement statement;
    private static String host;
    private static String username;
    private static String password;
    private static Connection connection;


    @Autowired
    DatabaseConnection(@Value("${database-live-url}") String host,
                       @Value("${database-username}") String username,
                       @Value("${database-password}") String password) throws SQLException {
        this.host = host;
        this.username = username;
        this.password = password;
        connection = DriverManager.getConnection(host, username, password);
    }


    static Statement connectToDatabase(){
        try {
            statement = connection.createStatement();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return statement;
    }

    static PreparedStatement connectToDatabase(String sql){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return preparedStatement;
    }

    static CallableStatement callStoredProcedure(String storedProcedureName) throws SQLException {
        return connection.prepareCall("{CALL "+storedProcedureName+"}");
    }


    public static List<String> testDBConnection() throws SQLException{
        Statement statement = connectToDatabase();
        String query = "select * from roles";
        ResultSet resultSet = statement.executeQuery(query);
        List<String> resultSetList = new ArrayList<>();
        resultSet.beforeFirst();
        while(resultSet.next()){
            resultSetList.add((resultSet.getString("roleName")));
        }
        return resultSetList;
    }

}

