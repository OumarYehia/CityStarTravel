package com.citystarstourseg.backend.Database;

import java.sql.SQLException;

public abstract class EntityCRUD<T> {

    public abstract int createRecords(T o) throws SQLException;
    public abstract int readRecords(T o);
    public abstract int updateRecords(T o);
    public abstract int deleteRecords(T o);
}
