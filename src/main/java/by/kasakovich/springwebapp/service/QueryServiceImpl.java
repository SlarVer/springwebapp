package by.kasakovich.springwebapp.service;

import by.kasakovich.springwebapp.dao.QueryDao;
import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.model.Query;
import by.kasakovich.springwebapp.model.DbTable;
import by.kasakovich.springwebapp.model.User;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService{
    @Autowired
    public QueryDao queryDao;

    @Override
    @Transactional
    public List execute(Query query, User user/*Login login*/) {
        return queryDao.execute(query, user);
    }

    @Override
    public List<DbTable> scanTables() {
        return queryDao.scanTables();
    }

    @Override
    public List<Query> showLogs(User user) {
        return queryDao.showLogs(user);
    }
}
