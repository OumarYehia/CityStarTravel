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


    @Autowired
    DatabaseConnection(@Value("${database-live-url}") String host,
                       @Value("${database-username}") String username,
                       @Value("${database-password}") String password){
        this.host = host;
        this.username = username;
        this.password = password;
    }


    public static Statement connectToDatabase(){
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            statement = connection.createStatement();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return statement;
    }

    public static PreparedStatement connectToDatabase(String sql){
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = DriverManager.getConnection(host, username, password);
            preparedStatement = connection.prepareStatement(sql);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return preparedStatement;
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

