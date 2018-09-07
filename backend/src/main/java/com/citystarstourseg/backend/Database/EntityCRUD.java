package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Bus;

import java.sql.SQLException;
import java.util.List;

public abstract class EntityCRUD<T> {

    public abstract T createRecords(T o) throws SQLException;
    public abstract List<T> readRecords(String id) throws SQLException;
    public abstract int updateRecords(T o)  throws SQLException;
    public abstract int deleteRecords(String o) throws SQLException;
}
