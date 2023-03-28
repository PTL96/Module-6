package com.example.backendspring.repository;

import com.example.backendspring.model.ThongTinSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IThongTinRepository extends JpaRepository<ThongTinSan, Integer> {
    @Query(value = "select * from thong_tin_san", nativeQuery = true)
    List<ThongTinSan> getAllThongTin();
}
