package com.example.shoeshopbackend.service;

import com.example.shoeshopbackend.dto.product.ProductView;
import com.example.shoeshopbackend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {
    Page<ProductView> getAllProduct(String name, String category, Pageable pageable);


    void save(Product product);

    Product findByIdProduct(Long id);

    void deleteProduct(Long id);
}
