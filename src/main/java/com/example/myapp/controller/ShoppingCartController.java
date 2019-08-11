package com.example.myapp.controller;

import com.example.myapp.service.ProductService;
import com.example.myapp.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductService productService;
    //product

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/productpage")
    public String productPage(Model model) {
        model.addAttribute("product",productService.getAll());
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
        model.addAttribute("cart",shoppingCartService.getProductsInCart().entrySet());
        model.addAttribute("total",shoppingCartService.getTotal().toString());
        return "cart";
    }
}
