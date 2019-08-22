package com.example.myapp.controller;
import com.example.myapp.exception.NotEnoughFundsException;
import com.example.myapp.exception.NotEnoughInStockException;
import com.example.myapp.model.Order;
import com.example.myapp.model.Status;
import com.example.myapp.model.User;
import com.example.myapp.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@Controller
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    PrincipalService principalService;

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

    @GetMapping("productpage/addproduct/{productId}")
    public String addProduct(@PathVariable("productId") Long productId,
                             @RequestParam("count") Integer count) {
        productService.findById(productId).ifPresent(product -> shoppingCartService.addProduct(product,count));
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("cart" ,shoppingCartService.getProductsInCart().entrySet());
        model.addAttribute("total" ,shoppingCartService.getTotal().toString());

        return "cart";
    }

    @GetMapping("/cart/removeProduct/{productId}")
    public String removeProduct(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::removeProduct);
        return "redirect:/cart";
    }

    @GetMapping("/productpage/checkout")
    public String checkout(Model model) {
        User user = userService.findByUsername(principalService.getPrincipal());
        try {
            shoppingCartService.checkout(new Order(LocalDateTime.now() ,shoppingCartService.getTotal() ,user ,Status.submitted));
        } catch (NotEnoughInStockException | NotEnoughFundsException e) {
            return cartPage(model.addAttribute("message" ,e.getMessage()));
        }
        return cartPage(model.addAttribute("message" ,"Order Placed!"));
    }
}