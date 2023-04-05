package com.example.shoeshopbackend.service;

import com.example.shoeshopbackend.entity.Category;


import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();

    Category findByIdCategory(Long id);
}
