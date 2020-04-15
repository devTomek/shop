package com.tomek.shop.controllers;

import com.tomek.shop.models.Product;
import com.tomek.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/many/{ids}")
    public List<Product> getProductsByIds(@PathVariable Set<Long> ids) {
        return productRepository.findAllById(ids);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @PostMapping("/many")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        productRepository.saveAll(products);
        return products;
    }

    @DeleteMapping("{id}")
    public Long deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return id;
    }

    @DeleteMapping("many/{ids}")
    public Set<Long> deleteProductsById(@PathVariable Set<Long> ids) {
        productRepository.deleteAll(productRepository.findAllById(ids));
        return ids;
    }

    @DeleteMapping
    public ArrayList<Product> deleteProducts() {
        productRepository.deleteAll();
        return new ArrayList<>();
    }

}
