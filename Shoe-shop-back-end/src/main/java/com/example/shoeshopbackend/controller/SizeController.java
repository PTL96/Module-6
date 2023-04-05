package com.example.shoeshopbackend.controller;

import com.example.shoeshopbackend.entity.Size;
import com.example.shoeshopbackend.service.impl.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("size")
@CrossOrigin("*")
public class SizeController {
    @Autowired
    private SizeService sizeService;

    @GetMapping("")
    public ResponseEntity<List<Size>> getAll() {
        List<Size> sizeList = sizeService.getAllSize();
        if (sizeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }
}
