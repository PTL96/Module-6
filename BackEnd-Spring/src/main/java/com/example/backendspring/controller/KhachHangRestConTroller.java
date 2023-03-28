package com.example.backendspring.controller;

import com.example.backendspring.model.KhachHang;
import com.example.backendspring.model.SanBong;
import com.example.backendspring.service.ipml.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/khachhang")
@CrossOrigin("*")
public class KhachHangRestConTroller {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("")
    public ResponseEntity<List<KhachHang>> getAll() {
        List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
        if (khachHangList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(khachHangList, HttpStatus.OK);
    }

}
