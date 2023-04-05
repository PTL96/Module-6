package com.example.shoeshopbackend.service.impl;

import com.example.shoeshopbackend.dto.product.ProductView;
import com.example.shoeshopbackend.entity.Product;
import com.example.shoeshopbackend.repository.IProductRepository;
import com.example.shoeshopbackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<ProductView> getAllProduct(String name, String category, Pageable pageable) {
        return iProductRepository.findAllPage(name, category, pageable);
    }

    @Override
    public void save(Product product) {
        product.setFlagDelete(true);
        iProductRepository.save(product);
    }

    @Override
    public Product findByIdProduct(Long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = this.findByIdProduct(id);
        product.setFlagDelete(false);
        iProductRepository.save(product);
    }


}
