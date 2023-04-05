package com.example.shoeshopbackend.service.impl;

import com.example.shoeshopbackend.entity.WareHouse;
import com.example.shoeshopbackend.repository.IWareHouseRepository;
import com.example.shoeshopbackend.service.IWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseService implements IWareHouseService {
    @Autowired
    IWareHouseRepository iWareHouseRepository;

    @Override
    public List<WareHouse> getAllWareHouse() {
        return iWareHouseRepository.findAll();
    }

    @Override
    public void saveWareHouse(WareHouse wareHouse) {
        iWareHouseRepository.save(wareHouse);
    }
}
