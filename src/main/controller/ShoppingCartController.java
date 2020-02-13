package main.controller;

import lombok.RequiredArgsConstructor;
import main.service.service.ProductService;
import main.service.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class ShoppingCartController {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;


    @GetMapping("/productpage")
    public String productPage(Model model) {
        model.addAttribute("product" ,productService.getAll());
        return "productpage";
    }

    @PostMapping("productpage/addproduct/{productId}")
    public String addProduct(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::addProduct);
        return "redirect:/productpage";
    }

    @PostMapping("cart/remove/{productId}")
    public String remove(@PathVariable("productId") Long productId) {
        productService.findById(productId).ifPresent(shoppingCartService::removeProduct);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("cart" ,shoppingCartService.getProductsInCart().entrySet());
        model.addAttribute("total" ,shoppingCartService.getTotal());
        return "cart";
    }

    @PostMapping("/cart/refreshProduct/{productId}")
    public String refresh(@PathVariable("productId") Long productId,
                          @RequestParam("cartCount") Integer cartQuantity) {
        productService.findById(productId).ifPresent(product -> shoppingCartService.setProductQuantity(product,cartQuantity));
        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(Model model) {
        String message;
        try {
            shoppingCartService.checkout();
            message = "Order Placed!";
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        return cartPage(model.addAttribute("message" ,message));
    }
}