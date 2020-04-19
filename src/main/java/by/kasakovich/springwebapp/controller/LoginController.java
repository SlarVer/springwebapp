package by.kasakovich.springwebapp.controller;

import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.model.User;
import by.kasakovich.springwebapp.service.UserService;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import static by.kasakovich.springwebapp.constants.ApplicationStringConstants.SQL_PATH;

@Controller
public class LoginController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() throws Exception{
        Reader reader = new BufferedReader(new FileReader(SQL_PATH));
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String mysqlUrl = "jdbc:mysql://localhost:3306?serverTimezone=Europe/Minsk&useSSL=false";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "13Root37");
        ScriptRunner scriptRunner = new ScriptRunner(con);
        scriptRunner.runScript(reader);
        return "home";
    }

    @RequestMapping("/home")
    public String loginHome(){
        return "home";
    }

    @GetMapping(value = "/login")
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }


    @PostMapping(value = "/loginProcess")
    public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
        ModelAndView modelAndView;
        User user = userService.validateUser(login);
        if (null != user) {
            modelAndView = new ModelAndView("welcome");
            modelAndView.addObject("name", user.getName());
        } else {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("message", "Username or Password is wrong!!");
        }
        return modelAndView;
    }
}
