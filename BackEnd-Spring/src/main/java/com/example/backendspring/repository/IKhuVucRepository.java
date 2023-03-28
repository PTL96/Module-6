package com.example.backendspring.repository;

import com.example.backendspring.model.KhuVuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhuVucRepository extends JpaRepository<KhuVuc, Integer> {
    @Query(value = "select * from khu_vuc", nativeQuery = true)
    List<KhuVuc> getAllKhuVuc();
}
