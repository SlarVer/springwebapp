package by.kasakovich.springwebapp.service;

import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.model.User;

public interface UserService {

    boolean register(User user);

    User validateUser(Login login);
}