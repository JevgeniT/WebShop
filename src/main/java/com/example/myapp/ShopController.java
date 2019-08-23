package com.example.myapp;

import com.example.myapp.model.Order;
import com.example.myapp.model.Product;
import com.example.myapp.model.User;
import com.example.myapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//@Controller
public class ShopController {


    public static void main(String[] args) {
        User user = new User();
        System.out.println(user);


    }
}