package by.kasakovich.springwebapp.dao;

import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean register(User user) {
        String sql = "from User where username='"
                + user.getUsername() + "' or email='" + user.getEmail() + "'";
        List<User> users = sessionFactory.getCurrentSession().createQuery(sql, User.class).getResultList();
        if (users.size() == 0) {
            if (user.getUsername().equals("admin")){
                user.setRole("Admin");
            } else {
                user.setRole("User");
            }
            sessionFactory.getCurrentSession().persist(user);
            return true;
        }
        return false;
    }

    @Override
    public User validateUser(Login login) {
        String sql = "from User where username='"
                + login.getUsername() + "' and password='" + login.getPassword() + "'";
        List<User> users = sessionFactory.getCurrentSession().createQuery(sql, User.class).getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }
}