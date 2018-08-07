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
public class SpareCRUD extends EntityCRUD<Bus> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public int createRecords(Bus bus) throws SQLException {
        // TODO: to be implemented
        return -1;
    }

    @Override
    public List<Bus> readRecords(String busID) throws SQLException {
        // TODO: to be implemented
        return new ArrayList<>();
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
