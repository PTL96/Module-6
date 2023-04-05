package com.example.shoeshopbackend.service.impl;

import com.example.shoeshopbackend.entity.Size;
import com.example.shoeshopbackend.repository.ISizeRepository;
import com.example.shoeshopbackend.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private ISizeRepository iSizeRepository;

    @Override
    public List<Size> getAllSize() {
        return iSizeRepository.findAll();
    }
}
