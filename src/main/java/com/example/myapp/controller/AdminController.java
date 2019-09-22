package com.example.myapp.controller;
import com.example.myapp.model.Product;
import com.example.myapp.model.Status;
import com.example.myapp.model.User;
import com.example.myapp.service.service.OrderService;
import com.example.myapp.service.service.ProductService;
import com.example.myapp.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

@RequiredArgsConstructor
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping({"/users" ,"/"})
    public String adminPage(Model model) {
        model.addAttribute("userList" ,userService.findAll());
        return "admin/adminpage";
    }

    @GetMapping("account/{userId}")
    public String userInfo(@PathVariable("userId") Long userId ,Model model) {
        model.addAttribute("userDetail" ,userService.findByUserId(userId));
        return "account";
    }

    @PostMapping("account/edit/{userId}")
    public String editUser(@PathVariable("userId") Long userId ,
                           @RequestParam("userName") String userName,
                           @RequestParam("newBalance") Integer newBalance) {
        User user = userService.findByUserId(userId);
        if (!userName.isEmpty()){
            user.setUsername(userName);
        }
        if (newBalance!=null){
            user.setBalance(BigDecimal.valueOf(newBalance));
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/products")
    public String productInfo(Model model) {
        model.addAttribute("productslist" ,productService.getAll());
        return "admin/products";
    }

    @GetMapping("/product/edit/{productId}")
    public String editProduct(@PathVariable("productId") Long productId,Model model) {
        return productInfo(model.addAttribute("prod",productService.findById(productId).orElseThrow(NoSuchFieldError::new)));
    }

    @PostMapping("/products/save")
    public String addProduct(@RequestParam("productId") Long productId,
                             @RequestParam("name") String name ,
                             @RequestParam("price") Double price ,
                             @RequestParam("quantity") Integer quantity) {
        Product product;
        if (productId==null){
            product = new Product(name, quantity, new BigDecimal(price));
        }else{
             product = productService.findById(productId).orElseThrow(NoSuchFieldError::new);
            if (!name.isEmpty()){
                product.setName(name);
            }
            if (price != null) {
                product.setPrice(new BigDecimal(price));
            }
            if (quantity != null) {
                product.setQuantity(quantity);
            }
        }
        productService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/product/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId) {
        Product product = productService.findById(Long.parseLong(productId)).orElseThrow(NoSuchFieldError::new);
        productService.delete(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders" ,orderService.getAll());
        return "admin/orders";
    }

    @GetMapping("/setstatus/{orderId}")
    public String setStatus(@PathVariable("orderId") Long orderId ) {
        orderService.setStatus(orderId ,Status.Shipped ,new Date());
        return "redirect:/admin/orders/";
    }

}

