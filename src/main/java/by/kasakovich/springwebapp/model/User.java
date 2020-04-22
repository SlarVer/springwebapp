package by.kasakovich.springwebapp.model;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Objects;

import static by.kasakovich.springwebapp.constants.ApplicationStringConstants.*;

@Entity
@Table(name = USERS_TABLE_NAME)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = USERS_COLUMN_ID, length = 10)
    private long id;

    @Column(name = USERS_COLUMN_USERNAME)
    private String username;

    @Column(name = USERS_COLUMN_PASSWORD)
    private String password;

    @Column(name = USERS_COLUMN_NAME)
    private String name;

    @Column(name = USERS_COLUMN_EMAIL)
    private String email;

    @Column(name = USERS_COLUMN_ROLE)
    private Role role;

    public User(){

    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
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
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
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
        return Objects.hash(getId(), getUsername(), getPassword(), getName(), getEmail(), getRole());
    }
}

