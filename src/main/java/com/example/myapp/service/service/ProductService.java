package com.example.myapp.service.service;

import com.example.myapp.model.Product;
import com.example.myapp.repos.ProductRepository;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Optional<Product> findById(Long id);

}