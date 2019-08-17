package com.example.myapp.controller;
import com.example.myapp.model.User;
import com.example.myapp.service.service.OrderService;
import com.example.myapp.service.service.PrincipalService;
import com.example.myapp.service.service.SecurityService;
import com.example.myapp.service.service.UserService;
import com.example.myapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sun.security.ssl.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    PrincipalService principalService;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm,BindingResult bindingResult,Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
           model.addAttribute("message","input error");
           return "registration";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error" ,"Your username and password is invalid.");
        }
        if (logout != null){
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }

    @GetMapping({"/","/main"})
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/account")
    public String account(Model model) {
        String userName = principalService.getPrincipal();
        User user = userService.findByUsername(userName);
        model.addAttribute("name",user.getUsername());
        model.addAttribute("role",user.getRoles().toString());
        model.addAttribute("balance",user.getBalance().toString());
        model.addAttribute("orders",user.getOrders());
        return "account";
    }
}