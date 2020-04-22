package by.kasakovich.springwebapp.dao;

import by.kasakovich.springwebapp.model.DbTable;
import by.kasakovich.springwebapp.model.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryDaoImpl implements QueryDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object> execute(Query query) {
        return entityManager.createNativeQuery(query.getQuery()).getResultList();
    }

    @Override
    public List<DbTable> scanTables() {
        List<Object> allTables = entityManager.createNativeQuery("SHOW TABLES;").getResultList();
        List<DbTable> availableDbTables = new ArrayList<>();
        for(Object table: allTables){
            if(!table.equals("users") && !table.equals("query")){
                /*List<Object[]> tableData = entityManager.createNativeQuery(
                        "DESCRIBE " + table + " ;").getResultList();*/
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
}
