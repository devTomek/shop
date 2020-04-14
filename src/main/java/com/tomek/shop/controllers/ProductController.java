package com.tomek.shop.controllers;

import com.tomek.shop.models.Product;
import com.tomek.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/{ids}")
    public ArrayList<Product> getProductsByIds(@RequestParam Set<Long> ids) {
        return (ArrayList<Product>) productService.findAllById(ids);
    }

    @PostMapping
    public Optional<Product> addProduct(@RequestBody Product product) {
        Product result = productService.save(product);
        return productService.findById(result.getId());
    }

    @DeleteMapping
    public ArrayList<Product> deleteProducts() {
        productService.deleteAll();
        return (ArrayList<Product>) productService.findAll();
    }

}
