package com.example.backendspring.repository;

import com.example.backendspring.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhachHangRepository extends JpaRepository <KhachHang, Integer> {
    @Query(value = "select * from khach_hang", nativeQuery = true)
    List<KhachHang> getAllKhachHang();
}
