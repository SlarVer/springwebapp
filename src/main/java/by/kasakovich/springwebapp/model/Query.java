package by.kasakovich.springwebapp.model;

import javax.persistence.*;
import javax.persistence.Table;

import static by.kasakovich.springwebapp.constants.ApplicationStringConstants.*;

@Entity
@Table(name = QUERY_TABLE_NAME)
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = QUERY_COLUMN_ID, length = 10)
    private long id;

    @Column(name = QUERY_COLUMN_USER)
    private String user;

    @Column(name = QUERY_COLUMN_QUERY)
    private String query;

    @Column(name = QUERY_COLUMN_RESULT)
    private String result;

    public Query(){

    }

    public Query(Object[] array){
        id = (Integer)array[0];
        user = (String)array[1];
        query = (String)array[2];
        result = (String)array[3];
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
