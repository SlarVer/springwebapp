package by.kasakovich.springwebapp.model;

import javax.persistence.*;
import java.util.Objects;

import static by.kasakovich.springwebapp.constants.ApplicationStringConstants.*;

@Entity
@Table(name = TABLE_NAME)
public class User {
    @Id
    @Column(name = COLUMN_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = COLUMN_USERNAME)
    private String username;

    @Column(name = COLUMN_PASSWORD)
    private String password;

    @Column(name = COLUMN_NAME)
    private String name;

    @Column(name = COLUMN_EMAIL)
    private String email;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof by.kasakovich.springwebapp.model.User)) return false;
        by.kasakovich.springwebapp.model.User user = (by.kasakovich.springwebapp.model.User) o;
        return //getId() == user.getId() &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getName(), getEmail());
    }
}

