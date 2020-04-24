package by.kasakovich.springwebapp.service;

import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.model.Query;
import by.kasakovich.springwebapp.model.DbTable;
import by.kasakovich.springwebapp.model.User;
import org.hibernate.exception.SQLGrammarException;

import java.sql.SQLException;
import java.util.List;

public interface QueryService {
    List execute(Query query, User user/*Login login*/);
    List<DbTable> scanTables();
    List<Query> showLogs(User user);
}
