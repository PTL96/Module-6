package com.example.shoeshopbackend.service.impl;

import com.example.shoeshopbackend.entity.Category;
import com.example.shoeshopbackend.repository.ICategoryRepository;
import com.example.shoeshopbackend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findByIdCategory(Long id) {
        return iCategoryRepository.findById(id).get();
    }
}
