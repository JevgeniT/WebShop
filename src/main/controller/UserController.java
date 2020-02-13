package main.controller;
import main.model.User;
import main.service.service.PrincipalService;
import main.service.service.SecurityService;
import main.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
public class UserController {

    private final PrincipalService principalService;
    private final UserService userService;
    private final SecurityService securityService;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "login/registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid User user,BindingResult bindingResult,Model model) {

        if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errors", "Password not match!");
            return "login/registration";
        }

        if (userService.findByUsername(user.getUsername())!=null){
            model.addAttribute("errors", "User exists!");
            return "login/registration";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors",bindingResult.getFieldError().getDefaultMessage());
            return "login/registration";
        }

        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("errors" ,"Your username or password is invalid.");
        }
        if (logout != null){
            model.addAttribute("errors", "You have been logged out successfully.");
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