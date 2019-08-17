package com.example.myapp.controller;

import com.example.myapp.model.Order;
import com.example.myapp.model.Status;
import com.example.myapp.model.User;
import com.example.myapp.service.service.*;
import org.apache.tomcat.jni.Local;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    PrincipalService principalService;

    @Autowired
    private ProductService productService;

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService ,ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/productpage")
    public String productPage(Model model) {
        model.addAttribute("product" ,productService.getAll());
        return "productpage";
    }


    @GetMapping("/productpage/addProduct/{productId}")
    public String addProduct(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::addProduct);
        return "redirect:/productpage";
    }

    @GetMapping("/cart/removeProduct/{productId}")
    public String removeProduct(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::removeProduct);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("cart" ,shoppingCartService.getProductsInCart().entrySet());
        model.addAttribute("total" ,shoppingCartService.getTotal().toString());
        return "cart";
    }

    @GetMapping("/productpage/checkout")
    public String checkout(Model model) {

        String userName = principalService.getPrincipal();
        User user = userService.findByUsername(userName);
        LocalDateTime currentTime = LocalDateTime.now(); // Cr
       if (shoppingCartService.getTotal().compareTo(user.getBalance()) < 0) {
           shoppingCartService.checkout(new Order(currentTime ,shoppingCartService.getTotal() ,user,Status.submitted));
           user.setBalance(user.getBalance().subtract(shoppingCartService.getTotal()));
           userService.setBalance(user.getId(),user.getBalance().subtract(shoppingCartService.getTotal()));

           return "main";
       }


        return cartPage(model.addAttribute("compare","Not enough funds"));

    }
}