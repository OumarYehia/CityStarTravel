package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.Database.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class DatabaseConnectionController {

    @Autowired
    private DatabaseConnection databaseConnection;

    @RequestMapping("/roles")
    public List<String> getResultSet() throws SQLException{
        //databaseConnection = new DatabaseConnection();
        return DatabaseConnection.testDBConnection();
    }
}
