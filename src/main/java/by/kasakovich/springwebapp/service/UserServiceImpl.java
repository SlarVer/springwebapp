package by.kasakovich.springwebapp.service;

import by.kasakovich.springwebapp.dao.UserDao;
import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements by.kasakovich.springwebapp.service.UserService {
    @Autowired
    public UserDao userDao;

    @Override
    @Transactional
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    @Transactional
    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }

}