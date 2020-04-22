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

    public Query(){

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
}
