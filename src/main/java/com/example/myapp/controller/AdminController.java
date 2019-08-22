package com.example.myapp.controller;


import com.example.myapp.model.Product;
import com.example.myapp.model.Status;
import com.example.myapp.service.service.OrderService;
import com.example.myapp.service.service.ProductService;
import com.example.myapp.service.service.UserService;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.SQLSyntaxErrorException;
import java.time.LocalDateTime;


@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;


    @RequestMapping({"/users" ,"/"})
    public String adminPage(Model model) {
        model.addAttribute("userList" ,userService.findAll());
        return "admin/adminpage";
    }

    @RequestMapping("/users/{userId}")
    public String userInfo(@PathVariable("userId") Long userId ,Model model) {
        model.addAttribute("singleUser" ,userService.findByUserId(userId));
        return "admin/userpage";
    }

    @PostMapping("/setbalance/{userId}")
    public String setBalance(@PathVariable("userId") Long userId ,
                             @RequestParam("newBalance") String newBalance) {
        userService.setBalance(userId ,new BigDecimal(newBalance));
        return "redirect:/admin/users/{userId}";
    }

    @GetMapping("/setstatus/{orderId}")
    public String setStatus(@PathVariable("orderId") Long orderId ,Model model) {
        //        model.addAttribute("message",orderService.findById(orderId));
        orderService.setStatus(orderId ,Status.shipped ,LocalDateTime.now());
        return "redirect:/admin/orders/";
    }

    @RequestMapping("/products")
    public String productInfo(Model model) {
        model.addAttribute("productslist" ,productService.getAll());
        return "admin/products";
    }

    @PostMapping("/products/save")
    public String addProduct(@RequestParam("name") String name ,
                             @RequestParam("price") String price ,
                             @RequestParam("quantity") String quantity) {
        productService.save(new Product(name ,Integer.parseInt(quantity) ,new BigDecimal(price)));
        return "redirect:/admin/products";
    }


    @PostMapping("/product/edit/{productId}")
    public String editProduct(@PathVariable("productId") String productId ,
                              @RequestParam("name") String name ,
                              @RequestParam("price") String price ,
                              @RequestParam("quantity") String quantity) {

        Product product = productService.findById(Long.parseLong(productId)).orElseThrow(NoSuchFieldError::new);
        product.setName(name);
        product.setQuantity(Integer.parseInt(quantity));
        product.setPrice(new BigDecimal(price));
        productService.save(product);
        return "redirect:/admin/products";
    }


    @GetMapping("/product/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId) {
        Product product = productService.findById(Long.parseLong(productId)).orElseThrow(NoSuchFieldError::new);
        productService.delete(product);
        return "redirect:/admin/products";
    }


    @RequestMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders" ,orderService.getAll());
        return "admin/orders";
    }
}

