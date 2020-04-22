package by.kasakovich.springwebapp.service;

import by.kasakovich.springwebapp.dao.QueryDao;
import by.kasakovich.springwebapp.model.Query;
import by.kasakovich.springwebapp.model.DbTable;
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
    public List<Object> execute(Query query) throws SQLException {
        return queryDao.execute(query);
    }

    @Override
    public List<DbTable> scanTables() {
        return queryDao.scanTables();
    }
}
