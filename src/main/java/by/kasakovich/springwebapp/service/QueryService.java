package by.kasakovich.springwebapp.service;

import by.kasakovich.springwebapp.model.Query;
import by.kasakovich.springwebapp.model.DbTable;

import java.sql.SQLException;
import java.util.List;

public interface QueryService {
    List<Object> execute(Query query) throws SQLException;
    List<DbTable> scanTables();
}
