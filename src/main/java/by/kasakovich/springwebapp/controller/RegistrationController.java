package by.kasakovich.springwebapp.controller;

import by.kasakovich.springwebapp.model.User;
import by.kasakovich.springwebapp.model.Login;
import by.kasakovich.springwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public ModelAndView showRegister() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping(value = "/registerprocess")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView;
        boolean isRegistered = userService.register(user);
        if(isRegistered){
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("login", new Login(user.getUsername(), user.getPassword()));
        } else {
            modelAndView = new ModelAndView("register");
            modelAndView.addObject("message", "Username or email are already taken!");
        }
        return modelAndView;
    }
}
