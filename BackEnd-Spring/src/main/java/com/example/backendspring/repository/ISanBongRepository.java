package com.example.backendspring.repository;

import com.example.backendspring.model.SanBong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ISanBongRepository extends JpaRepository<SanBong, Integer> {

    @Query(value = "select * from san_bong", nativeQuery = true)
    List<SanBong> getAllSanBong();

}
