package com.tomek.shop.controllers;

import com.tomek.shop.models.Product;
import com.tomek.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(productService.findAll());
    }

    @PostMapping
    @ResponseBody
    public Optional<Product> addProduct(@RequestParam("name") String name) {
        Product product = productService.save(new Product(name));
        return productService.findById(product.getId());
    }

}