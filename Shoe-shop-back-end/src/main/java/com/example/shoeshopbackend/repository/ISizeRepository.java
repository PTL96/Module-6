package com.example.shoeshopbackend.repository;


import com.example.shoeshopbackend.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISizeRepository extends JpaRepository<Size,Long> {
}
