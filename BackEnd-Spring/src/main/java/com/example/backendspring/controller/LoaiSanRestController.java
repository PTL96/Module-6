package com.example.backendspring.controller;

import com.example.backendspring.model.KhuVuc;
import com.example.backendspring.model.LoaiSan;
import com.example.backendspring.service.ipml.LoaiSanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loaisan")
@CrossOrigin("*")
public class LoaiSanRestController {
    @Autowired
    private LoaiSanService loaiSanService;

    @GetMapping("")
    public ResponseEntity<List<LoaiSan>> getAll() {
        List<LoaiSan> loaiSanList = loaiSanService.getAllLoaiSan();
        if (loaiSanList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(loaiSanList, HttpStatus.OK);
    }
}
