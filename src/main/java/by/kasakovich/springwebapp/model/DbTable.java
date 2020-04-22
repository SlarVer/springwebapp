package by.kasakovich.springwebapp.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


public class DbTable {
    private String title;
    private List<String> data = new ArrayList<>();

    public DbTable(){

    }

    public DbTable(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getData() {
        return data;
    }
    public void setData(List<String> data) {
        this.data = data;
    }
}
