package by.kasakovich.springwebapp.dao;

import by.kasakovich.springwebapp.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryDaoImpl implements QueryDao{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List execute(Query query, User user/* Login login*/) {
        String request = query.getQuery();
        List<Object> result = new ArrayList<>();
        try {
            if (request.contains("SELECT")) {
                List<Object[]> queryResult = entityManager.createNativeQuery(request).getResultList();
                if (request.contains("rooster")) {
                    for (Object[] arr : queryResult) {
                        result.add(new RoosterTable(arr));
                    }
                } else {
                    for (Object[] arr : queryResult) {
                        result.add(new StafflistTable(arr));
                    }
                }
                String queryInsert = "INSERT INTO query (user, query, result) VALUES ('" + user.getUsername() +
                        "', '" + query.getQuery() + "', '" + result.size() + " rows selected');";
                entityManager.createNativeQuery(queryInsert).executeUpdate();
            } else {
                entityManager.createNativeQuery(request).executeUpdate();
                String operationType = request.substring(0, request.indexOf(" "));
                result.add(operationType + " successful");
                String queryInsert = "INSERT INTO query (user, query, result) VALUES ('" + user.getUsername() +
                        "', '" + query.getQuery() + "', '" + operationType + " successful');";
                entityManager.createNativeQuery(queryInsert).executeUpdate();
            }
        } catch (SQLGrammarException exception){
            exception.printStackTrace();
            String queryInsert = "INSERT INTO query (user, query, result) VALUES ('" + user.getUsername() +
                    "', '" + query.getQuery() + "', '" + exception.getLocalizedMessage() + "');";
            entityManager.createNativeQuery(queryInsert).executeUpdate();
        }
        return result;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<DbTable> scanTables() {
        List<Object> allTables = entityManager.createNativeQuery("SHOW TABLES;").getResultList();
        List<DbTable> availableDbTables = new ArrayList<>();
        for(Object table: allTables){
            if(!table.equals("users") && !table.equals("query")){
                List<Object> tableData = entityManager.createNativeQuery(
                        "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS " +
                                "WHERE table_name = '" + table + "' AND table_schema = 'springwebappdb';"
                ).getResultList();
                DbTable availableDbTable = new DbTable((String)table);
                for (Object o: tableData){
                    availableDbTable.getData().add((String)o);
                }
                availableDbTables.add(availableDbTable);
            }
        }
        return availableDbTables;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Query> showLogs(User user) {
        List<Object[]> objectLogs = entityManager.createNativeQuery(
                "SELECT * FROM query WHERE user = '" + user.getUsername() + "';").getResultList();
        List<Query> logs = new ArrayList();
        for(Object[] array: objectLogs){
            logs.add(new Query(array));
        }
        return logs;
    }
}
