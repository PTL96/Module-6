package com.example.shoeshopbackend.repository;

import com.example.shoeshopbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
