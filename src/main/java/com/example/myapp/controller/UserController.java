package com.example.myapp.controller;
import com.example.myapp.model.User;
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
        return "login/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm,BindingResult bindingResult,Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("error","placeholder"); //application.properties
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
        return "login/login";
    }

    @GetMapping({"/","/main"})
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("userDetail",userService.findByUsername(principalService.getPrincipal()));
        return "account";
    }
}