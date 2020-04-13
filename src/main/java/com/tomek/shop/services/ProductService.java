package com.tomek.shop.services;

import com.tomek.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductService extends JpaRepository<Product, Long> {
}
