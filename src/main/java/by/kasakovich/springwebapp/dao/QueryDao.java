package by.kasakovich.springwebapp.dao;

import by.kasakovich.springwebapp.model.DbTable;
import by.kasakovich.springwebapp.model.Query;

import java.util.List;

public interface QueryDao {
    List<Object> execute(Query query);
    List<DbTable> scanTables();
}
