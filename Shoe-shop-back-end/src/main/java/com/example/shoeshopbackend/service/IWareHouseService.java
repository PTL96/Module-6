package com.example.shoeshopbackend.service;


import com.example.shoeshopbackend.entity.WareHouse;

import java.util.List;

public interface IWareHouseService {
    List<WareHouse> getAllWareHouse();

    void saveWareHouse(WareHouse wareHouse);
}
