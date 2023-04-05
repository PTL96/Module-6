package com.example.shoeshopbackend.repository;

import com.example.shoeshopbackend.entity.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IWareHouseRepository extends JpaRepository<WareHouse, Long> {
}
