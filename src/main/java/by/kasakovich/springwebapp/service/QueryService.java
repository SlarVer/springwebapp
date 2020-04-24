package by.kasakovich.springwebapp.service;

import by.kasakovich.springwebapp.model.Query;
import by.kasakovich.springwebapp.model.DbTable;
import by.kasakovich.springwebapp.model.User;

import java.util.List;

public interface QueryService {
    List execute(Query query, User user);
    List<DbTable> scanTables();
    List<Query> showLogs(User user);
}
