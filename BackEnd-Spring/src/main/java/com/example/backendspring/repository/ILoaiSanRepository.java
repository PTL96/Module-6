package com.example.backendspring.repository;

import com.example.backendspring.model.LoaiSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoaiSanRepository extends JpaRepository <LoaiSan, Integer> {
    @Query(value = "select * from loai_san", nativeQuery = true)
    List<LoaiSan> getAllLoaiSan();
}
