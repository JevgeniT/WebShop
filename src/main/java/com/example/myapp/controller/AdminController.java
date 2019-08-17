package com.example.myapp.controller;


import com.example.myapp.model.Status;
import com.example.myapp.service.service.OrderService;
import com.example.myapp.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/users")
    public String adminPage(Model model){
        model.addAttribute("test",userService.findAll());
        return "adminpage";
    }

    @RequestMapping("/users/{userId}")
    public String userInfo(@PathVariable("userId") Long userId,Model model){
        model.addAttribute("test",userService.findByUserId(userId));
        return "userpage";
    }


    @GetMapping("/setbalance/{userId}")
    public String setBalance(@PathVariable("userId") Long userId,Model model){
            userService.setBalance(userId,BigDecimal.valueOf(66));
            return "userpage";
    }

    @GetMapping("/setstatus/{orderId}")
    public String setStatus(@PathVariable("orderId") Long orderId,Model model){
        model.addAttribute("message",orderService.findById(orderId));
        LocalDateTime currentTime = LocalDateTime.now();
        orderService.setStatus(orderId,Status.shipped,currentTime);
        return "adminpage";
    }
}

