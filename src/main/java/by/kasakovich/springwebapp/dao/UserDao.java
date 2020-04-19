package by.kasakovich.springwebapp.dao;

import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.model.User;

public interface UserDao {
    boolean register(User user);
    User validateUser(Login login);
}
