package com.example.myapp.service.impl;

import com.example.myapp.model.Product;
import com.example.myapp.repos.ProductRepository;
import com.example.myapp.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
         productRepository.save(product);
    }


    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
