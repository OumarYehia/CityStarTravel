package com.citystarstourseg.backend.Database;

import java.sql.SQLException;
import java.util.List;

public abstract class EntityCRUD<T> {

    public abstract int createRecords(T o) throws SQLException;
    public abstract List<T> readRecords(String id) throws SQLException;
    public abstract int updateRecords(T o);
    public abstract int deleteRecords(T o);
}
