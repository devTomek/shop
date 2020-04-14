package com.tomek.shop.controllers;

import com.tomek.shop.models.Product;
import com.tomek.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/{ids}")
    public ArrayList<Product> getProductsByIds(@RequestParam Set<Long> ids) {
        return (ArrayList<Product>) productRepository.findAllById(ids);
    }

    @PostMapping
    public Optional<Product> addProduct(@RequestBody Product product) {
        Product result = productRepository.save(product);
        return productRepository.findById(result.getId());
    }

    @PostMapping("/many")
    public ArrayList<Product> addProducts(@RequestBody ArrayList<Product> products) {
        return (ArrayList<Product>) productRepository.saveAll(products);
    }

    @DeleteMapping
    public ArrayList<Product> deleteProducts() {
        productRepository.deleteAll();
        return (ArrayList<Product>) productRepository.findAll();
    }

}
