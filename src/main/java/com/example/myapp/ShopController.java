package com.example.myapp;

import com.example.myapp.model.Product;
import com.example.myapp.model.User;
import com.example.myapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//@Controller
public class ShopController {


    public static void main(String[] args) {
//
//        Product product = new Product();
//        product.setId(1l);
//        product.setName("test");
//        product.setPrice(10.00);
//        product.setQuantity(10);
//
//        Product product2 = new Product();
//        product2.setId(2l);
//        product2.setName("test");
//        product2.setPrice(5.00);
//        product2.setQuantity(10);
//
//        HashMap<Product,Integer> mymap= new HashMap();
//
//
//        mymap.put(product,1);
//        mymap.put(product2,2);
//
//        System.out.println(mymap);
//        Double val = mymap.entrySet().stream().mapToDouble(x->x.getKey().getPrice()*(x.getValue())).sum();
//        System.out.println(val);

    }
}